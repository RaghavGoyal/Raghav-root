package service

import play.api.cache.{AsyncCacheApi, DefaultSyncCacheApi, SyncCacheApi}

import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class DemoService @Inject()(longTaskService: LongTaskService, cacheService: SyncCacheApi) {

  def fetchData(key:String): String ={
    cacheService.get[String](key) match {
      case Some(value) => value
      case None =>
        val response = longTaskService.fetchValuefor(key)
        cacheService.set(key, response)
        response
    }

//    cacheServiceice.getOrElseUpdate(key)(Future(longTaskService.fetchValuefor(key)))

    // demonstrate getOrElseUpdate also.
  }
}

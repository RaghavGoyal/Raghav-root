package service

import play.api.cache.{AsyncCacheApi, DefaultSyncCacheApi, SyncCacheApi}

import javax.inject.{Inject, Singleton}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class DemoService @Inject()(longTaskService: LongTaskService, cacheService: SyncCacheApi) {

  def fetchData(key:String): String ={
//    cacheService.get[String](key) match {
//      case Some(value) => value
//      case None =>
//        val response = longTaskService.fetchValuefor(key)
//        cacheService.set(key, response)
//        response
//    }
    cacheService.getOrElseUpdate(key)(longTaskService.fetchValuefor(key))

    // demonstrate getOrElseUpdate also.
    // demonstrate AsyncCacheApi
    // cacheService.getOrElseUpdate(key)(Future(longTaskService.fetchValuefor(key)))

    // exp time
    // clear cache
  }

  def clearCache(key: String) ={
    cacheService.remove(key)
    s"Successfully removed $key from cache"
  }
}

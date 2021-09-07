from flask import abort

from src.repository.electricity_reading_repository import ElectricityReadingRepository
from src.service.electricity_reading_service import ElectricityReadingService

repository = ElectricityReadingRepository()
service = ElectricityReadingService(repository)


def viewConsumption(smart_meter_id):
    readings = service.retrieve_readings_for(smart_meter_id)
    print(readings)

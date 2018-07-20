cmake_minimum_required(VERSION 2.8.10)
project(iio-event-monitor)
add_executable(iio-event-monitor iio_utils.c iio-event-monitor.c)
install(TARGETS iio-event-monitor DESTINATION bin)

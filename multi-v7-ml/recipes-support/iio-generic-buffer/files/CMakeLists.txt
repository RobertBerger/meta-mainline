cmake_minimum_required(VERSION 2.8.10)
project(iio-generic-buffer)
add_executable(iio-generic-buffer iio_utils.c iio-generic-buffer.c)
install(TARGETS iio-generic-buffer DESTINATION bin)

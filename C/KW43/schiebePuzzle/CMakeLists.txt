cmake_minimum_required(VERSION 3.23)
project(schiebePuzzle C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(schiebePuzzle
        main.c
        utils.c
        utils.h)

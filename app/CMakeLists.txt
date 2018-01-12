

cmake_minimum_required(VERSION 3.4.1)

# configure import libs
set(distribution_DIR ${CMAKE_SOURCE_DIR}/../distribution)

add_library(lib_lame STATIC IMPORTED)
set_target_properties(lib_lame PROPERTIES IMPORTED_LOCATION
    ${distribution_DIR}/lame/lib/libmp3lame.a)



add_library(mp3encoder-lib SHARED
             src/main/cpp/mp3_encoder.cpp
             src/main/cpp/jni_Mp3Encoder.cpp)

find_library(log-lib log)

target_include_directories(mp3encoder-lib PRIVATE
                           ${distribution_DIR}/lame/include)

target_link_libraries(mp3encoder-lib
                       ${log-lib}
                       lib_lame)
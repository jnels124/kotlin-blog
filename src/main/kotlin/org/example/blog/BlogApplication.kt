package org.example.blog

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogApplication

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args) {
        // TODO: how does this work
        setBannerMode(Banner.Mode.OFF)
        setDefaultProperties(mapOf("server.port" to "8081"))
    }
}

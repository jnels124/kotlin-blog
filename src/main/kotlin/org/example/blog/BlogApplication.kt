package org.example.blog

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class BlogApplication

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args) {
        // TODO: how does this work
        setBannerMode(Banner.Mode.OFF)
        setDefaultProperties(mapOf("server.port" to "8081"))
    }
}

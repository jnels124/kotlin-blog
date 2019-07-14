package org.example.blog

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/api/article")//TODO: shouldn't we have a version
class ArticleController(private val repository: ArticleRepository) {
    @GetMapping//TODO: does this default to /
    fun findAl() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")//TODO: shoudln't this be id, we can present a slug interface elsewhere, but this is weird
    fun findOne(@PathVariable slug: String) =
            repository.findBySlug(slug) ?: throw IllegalArgumentException("Wrong article slug provided")
    //TODO: shouldn't we return a 404?
}

@RestController
@RequestMapping("/api/user")//TODO: shouldn't we have a version
class UserController(private val repository: UserRepository) {
    @GetMapping//TODO: does this default to /
    fun findAll() = repository.findAll()

    @GetMapping("/{login}")//TODO: not all authors will have logins shouldn't this be id? we can present a by login interface elsewhere
    fun findOne(@PathVariable login: String) = repository.findByLogin(login)
}
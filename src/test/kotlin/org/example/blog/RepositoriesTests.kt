package org.example.blog

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository,
        val articleRepository: ArticleRepository) {
    private lateinit var juergen: User
    private lateinit var article: Article

    @BeforeEach
    private fun beforeEach() {
        juergen = User("springjuergen", "Juergen", "Hoeller")
        article = Article("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", juergen)
        entityManager.persist(juergen)
        entityManager.persist(article)
        entityManager.flush()
    }

    @Test
    fun `When findByIdOrNull then return Article`() {
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val found = userRepository.findByLogin(juergen.login)
        assertThat(found).isEqualTo(juergen)
    }
}

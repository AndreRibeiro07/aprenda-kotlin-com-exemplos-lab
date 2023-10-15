// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

data class ConteudoEducacional(
    val nome : String,
    val url: String
)

data class Aluno(
    val nome: String,
    val email: String)

data class Formacao(
    val nome: String,
    val nivel: String,
    val conteudosEducacionais: MutableList<ConteudoEducacional> = mutableListOf(),
    val alunosMatriculados: MutableList<Aluno> = mutableListOf()
)

class Curso(val formacoes: MutableList<Formacao> = mutableListOf(), val alunos: MutableList<Aluno> = mutableListOf() ) {

    fun criarFormacao(nome : String, nivel : String){
        val formacao = Formacao(nome, nivel)
        formacoes.add(formacao)
    }

    fun adicionarConteudoFormacao(formacao: Formacao, conteudo: ConteudoEducacional){
    formacao.conteudosEducacionais.add(conteudo)
    }

    fun matricularAlunoEmFormacao(formacao: Formacao, aluno: Aluno){
        formacao.alunosMatriculados.add(aluno)
    }
}

fun main() {

    val curso = Curso()
    
    curso.criarFormacao("Iniciando o curso de Kotlin", "Nivel Básico")
    curso.criarFormacao("Avançando em Kotlin", "Intermediário")
    
    val conteudo1 = ConteudoEducacional("Introdução", "https://kotlinlang.org")
    val conteudo2 = ConteudoEducacional("Continuando em Java", "https://dev.java")
    curso.adicionarConteudoFormacao(curso.formacoes[0], conteudo1)
    curso.adicionarConteudoFormacao(curso.formacoes[1], conteudo2)

    val aluno1 = Aluno ("Felipe Toledo", "devfelitol@hotmail.com")
    val aluno2 = Aluno ("Marcos Rocha", "devmarrocha@outlook.com")
    val aluno3 = Aluno ("Josh Craig", "devjosh@gmail.com")
    
    curso.matricularAlunoEmFormacao(curso.formacoes[0], aluno1)
    curso.matricularAlunoEmFormacao(curso.formacoes[0], aluno2)
    curso.matricularAlunoEmFormacao(curso.formacoes[1], aluno3)
    
     println("Formações:")
        
    curso.formacoes.forEach { formacao ->
        println("Nome: ${formacao.nome}, Nível: ${formacao.nivel}")
        println("Conteúdos Educacionais:")
        formacao.conteudosEducacionais.forEach { conteudo ->
            println(" - Nome: ${conteudo.nome}, URL: ${conteudo.url}")
        }

        println("Alunos Matriculados:")
        formacao.alunosMatriculados.forEach { aluno -> 
            println(" - Nome: ${aluno.nome}, Email: ${aluno.email}")
        }
    }

}

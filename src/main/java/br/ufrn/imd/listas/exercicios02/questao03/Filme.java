package br.ufrn.imd.listas.exercicios02.questao03;

public class Filme {

    private String titulo;
    private double duracaoMin;
    private String diretor;

    final double MIN_DURACAO = 45.0;

    public Filme(String title, double duration, String director) throws FilmeNaoValidoException {
        if( duration < MIN_DURACAO || title.isBlank() || director.isBlank()) {
            throw new FilmeNaoValidoException("Dados inválidos para o filme.");
        } else {
            this.titulo = title;
            this.duracaoMin = duration;
            this.diretor = director;
        }
    }

    public Filme menorFilme(Filme outroFilme) throws FilmeNaoValidoException {

        if(this.titulo.equalsIgnoreCase(outroFilme.titulo)) {
            throw new FilmeNaoValidoException("Os filmes são iguais");
        } else if (this.duracaoMin < outroFilme.duracaoMin) {
            return this;
        } else {
            return outroFilme;
        }
    }

    public Boolean ehMesmoDiretor(Filme outroFilme) throws FilmeNaoValidoException {
        if(this.titulo.equalsIgnoreCase(outroFilme.titulo)) {
            throw new FilmeNaoValidoException("Os filmes são iguais");
        } else {
            return this.diretor.equalsIgnoreCase(outroFilme.diretor);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(double duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}

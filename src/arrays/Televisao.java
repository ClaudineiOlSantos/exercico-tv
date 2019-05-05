package arrays;

/**
 *
 * @author claudinei
 */
public class Televisao {

    private boolean ligado = false;
    private int volumeMaximo;
    private int volume;
    private String[] canais;
    private int canalAtual;

    public Televisao(int volumeMaximo, String[] canais) {
        this.volumeMaximo = volumeMaximo;
        this.canais = canais;

        //configurações adicionais
        this.canalAtual = 0;
        this.volume = 30;

    }

    public String ligaDesliga() {
        this.ligado = (this.ligado == false ? true : false);

        return (this.ligado ? "ligada" : "desligada");
    }

    public int aumentaVolume() throws Exception {
        this.ligada();
        if (this.volume < this.volumeMaximo) {
            this.volume += 1;
        }
        return this.volume;
    }

    public int diminueVolume() throws Exception {
        this.ligada();
        if (this.volume > 0) {
            this.volume -= 1;
        }
        return this.volume;
    }

    /**
     * Incrementa o canal em 1 unudade, se o canal passar de 10 canais a
     * contagem volta para 0 que é o primeiro canal.
     *
     * @return Retorna o canal atual
     */
    public String aumentaCanal() throws Exception {
        this.ligada();
        if (this.canalAtual < 9) {
            this.canalAtual += 1;
        } else if (this.canalAtual == 9) {
            this.canalAtual = 0;
        } else {
            this.canalAtual = 0;
        }

        return this.canais[this.canalAtual];
    }

    /**
     * Decrementa o canal em uma unidade.
     *
     * @return Retorna o canal atual.
     */
    public String diminueCanal() throws Exception {
        this.ligada();
        if (this.canalAtual > 1) {
            this.canalAtual -= 1;
        } else if (this.canalAtual == 0) {
            this.canalAtual = 9;
        } else {
            this.canalAtual = 0;
        }
        return this.canais[this.canalAtual];

    }

    /**
     * Direciona para o canal específico infirmado como parâmetro.
     *
     * @param canal Número do canal desejado
     * @return
     */
    public String mudaCanal(int canal) throws Exception {
        this.ligada();
        if (canal - 1 >= 0 && canal - 1 <= 100) {
            this.canalAtual = canal;
        }
        return this.canais[this.canalAtual];

    }

    /**
     * Retorna o número de canais disponpíveis
     *
     * @return
     */
    public int getNumeroCanais() throws Exception {
        this.ligada();
        return this.canais.length + 1;
    }

    public String getCanalAtual() {
        return this.canais[this.canalAtual];
    }

    /**
     * Se a TV estiver desligada lança uma excessão
     *
     * @throws Exception
     */
    private void ligada() throws Exception {
        if (!this.ligado) {
            throw new Exception("Primeiramente ligue a tv.");
        }
    }
}

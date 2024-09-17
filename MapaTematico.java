import java.util.Date;

//Tarefa 02: Identificar casos de reescrita de métodos
//Os casos de reescrita de métodos (override) ocorrem nas subclasses UsuarioAluno e UsuarioProfessor, onde os métodos getCotaMaxima() e getPrazoMaximo() são redefinidos para fornecer valores específicos para cada tipo de usuário.

//Tarefa 03: Identificar um caso de polimorfismo
//Um exemplo de polimorfismo no conjunto de códigos apresentados é o método empresta() na classe Livro e na classe Periodico. O método empresta() é chamado de forma diferente dependendo do tipo de objeto que o invoca (um Livro ou um Periodico).

//Tarefa 04: Importância de métodos auxiliares na codificação de classes
//Métodos auxiliares são importantes porque:

//Eles ajudam a manter o código organizado e legível, dividindo tarefas complexas em partes menores e mais gerenciáveis.
//Eles permitem a reutilização de código, evitando duplicação.
//Eles facilitam a manutenção e a atualização do código, pois mudanças em um método auxiliar não afetam diretamente outras partes do código.

//Tarefa 05: Mudança de estado de um objeto
//A mudança de estado de um objeto ocorre quando o valor de um ou mais atributos do objeto é alterado. Por exemplo, um livro muda de estado quando é emprestado (passa de disponível para emprestado) ou quando é devolvido (passa de emprestado para disponível). A construção de diagramas de estados facilita a codificação, pois fornece uma representação visual clara dos diferentes estados que um objeto pode ter e as transições entre esses estados.

//Tarefa 06: Importância da elaboração de diagramas de atividades
//Os diagramas de atividades são importantes porque:

//Eles ajudam a visualizar o fluxo de controle e as interações entre objetos durante a execução de um processo.
//Eles permitem identificar possíveis falhas ou omissões no design do sistema antes da implementação.
//Eles servem como documentação que pode ser útil para novos desenvolvedores que trabalham no projeto.

public class MapaTematico extends Item {
    private int nivelPrivilegio;
    private Usuario retiradoPor;
    private Date dtEmprestimo;
    private Date dtDevolucao;

    public MapaTematico(String titulo, int nivelPrivilegio) {
        super(titulo);
        this.nivelPrivilegio = nivelPrivilegio;
        this.retiradoPor = null;
        this.dtEmprestimo = null;
        this.dtDevolucao = null;
    }

    @Override
    public boolean empresta(Usuario u, int prazo) {
        if (this.retiradoPor == null && getNivelPrivilegio() >= this.nivelPrivilegio) {
            this.retiradoPor = u;
            this.dtEmprestimo = new Date();
            this.dtDevolucao = new Date();
            this.dtDevolucao.setDate(this.dtDevolucao.getDate() + prazo);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean retorna(Usuario u) {
        if (this.retiradoPor == u) {
            this.retiradoPor = null;
            this.dtEmprestimo = null;
            this.dtDevolucao = null;
            return true;
        } else {
            return false;
        }
    }

    public int getNivelPrivilegio() {
        return this.nivelPrivilegio;
    }

    public void setNivelPrivilegio(int nivelPrivilegio) {
        this.nivelPrivilegio = nivelPrivilegio;
    }
}
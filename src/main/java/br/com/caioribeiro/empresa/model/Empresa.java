package br.com.caioribeiro.empresa.model;

import static org.apache.commons.lang3.StringUtils.isNumeric;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.beanvalidation.tck.tests.xmlconfiguration.constraintdefinition.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.caioribeiro.empresa.stringbuilder.MyStyle;

/**
 * The Class Empresa.
 */
@Entity
public final class Empresa {

    // Variaveis de Atributo-------------------------------------------------------------------------------------

    /** O(a)(s) id. */
    @Id
    private Long id;

    /** O(a)(s) enderecos. */
    @NotEmpty(message = "A lista de endereços não pode estar vazia!")
    @NotNull(message = "A lista de endereços não pode estar vazia!")
    @Valid
    private Set<Endereco> enderecos;

    /** O(a)(s) telefones. */
    @NotEmpty(message = "A lista de telefones não pode estar vazia!")
    @NotNull(message = "A lista de telefones não pode estar vazia!")
    @Valid
    private Set<Telefone> telefones;

    /** O(a)(s) cnpj. */
    @Length(min = 14, max = 14, message = "O CNPJ deve ter {max} dígitos!")
    @NotBlank(message = "O CNPJ deve ser preenchido!")
    @CNPJ(formatted = true)
    @Pattern(regexp = "(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})", message = "O CNPJ deve estar no formato {regexp}")
    private String cnpj;

    /** O(a)(s) razao social. */
    @NotBlank(message = "A Razão Social deve ser preenchida!")
    @Length(min = 10, max = 80, message = "A Razão Social deve ter entre {min} e {max} letras!")
    @Pattern(regexp = "\\w[^|]|[^;]", message = "A Razão Social não pode conter pipe/ponto-vírgula!")
    private String razaoSocial;

    /** O(a)(s) nome fantasia. */
    @NotBlank(message = "O Nome Fantasia deve ser preenchido!")
    @Size(min = 10, max = 80, message = "O Nome Fantasia deve ter entre {min} e {max} letras!")
    @Pattern(regexp = "^[^|]|^[^;]*$", message = "O Nome Fantasia não pode conter pipe/ponto-vírgula!")
    private String nomeFantasia;

    /** O(a)(s) emails. */
    @NotEmpty(message = "A lista de E-mails não pode estar vazia!")
    @NotNull(message = "A lista de E-mails não pode estar vazia!")
    @Valid
    private Set<Email> emails;

    /** O(a)(s) data de cadastro. */
    @Future(message = "A data não pode ser anterior a data atual!")
    @Past(message = "A data não pode ser posterior a data atual!")
    @NotNull(message = "A data não pode ser nula!")
    private DateTime dataDeCadastro;

    /** O(a)(s) data de alteracao. */
    @Future(message = "A data não pode ser anterior a data atual!")
    @Past(message = "A data não pode ser posterior a data atual!")
    @NotNull(message = "A data não pode ser nula!")
    private DateTime dataDeAlteracao;

    // Getters e Setters------------------------------------------------------------------------------------------

    /**
     * Obtém o valor do(a)(s) id.
     *
     * @return O(a)(s) id
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtém o valor do(a)(s) enderecos.
     *
     * @return O(a)(s) enderecos
     */
    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * Obtém o valor do(a)(s) telefones.
     *
     * @return O(a)(s) telefones
     */
    public Set<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * Obtém o valor do(a)(s) cnpj.
     *
     * @return O(a)(s) cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Obtém o valor do(a)(s) razao social.
     *
     * @return O(a)(s) razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Obtém o valor do(a)(s) nome fantasia.
     *
     * @return O(a)(s) nome fantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Obtém o valor do(a)(s) emails.
     *
     * @return O(a)(s) emails
     */
    public Set<Email> getEmails() {
        return emails;
    }

    /**
     * Obtém o valor do(a)(s) data de cadastro.
     *
     * @return O(a)(s) data de cadastro
     */
    public DateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     * Define o valor do(a)(s) id.
     *
     * @param id o novo valor do(a)(s) id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Define o valor do(a)(s) endereco.
     *
     * @param enderecos o novo valor do(a)(s) endereco
     */
    public void setEndereco(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    /**
     * Define o valor do(a)(s) telefone.
     *
     * @param telefones o novo valor do(a)(s) telefone
     */
    public void setTelefone(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    /**
     * Define o valor do(a)(s) cnpj.
     *
     * @param cnpj o novo valor do(a)(s) cnpj
     */
    public void setCnpj(String cnpj) {
        isNumeric(cnpj);
        this.cnpj = cnpj;
    }

    /**
     * Define o valor do(a)(s) razao social.
     *
     * @param razaoSocial o novo valor do(a)(s) razao social
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * Define o valor do(a)(s) nome fantasia.
     *
     * @param nomeFantasia o novo valor do(a)(s) nome fantasia
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * Define o valor do(a)(s) emails.
     *
     * @param emails o novo valor do(a)(s) emails
     */
    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    /**
     * Define o valor do(a)(s) data de cadastro.
     *
     * @param dataDeCadastro o novo valor do(a)(s) data de cadastro
     */
    public void setDataDeCadastro(DateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    /**
     * Obtém o valor do(a)(s) data de alteracao.
     *
     * @return O(a)(s) data de alteracao
     */
    public DateTime getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    /**
     * Define o valor do(a)(s) data de alteracao.
     *
     * @param dataDeAlteracao o novo valor do(a)(s) data de alteracao
     */
    public void setDataDeAlteracao(DateTime dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    // hashCode, equals e to String----------------------------------------------------------------------------------------------------
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.cnpj).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) obj;
        return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/YYYY");
        return new ToStringBuilder(this, MyStyle.MY_STYLE).append(this.razaoSocial != null ? "Razão Social: " + this.razaoSocial : null).append(this.cnpj != null ? "CNPJ: " + this.cnpj : null)
                .append(enderecos != null ? "Endereço: " + enderecos : null).append(telefones != null ? "Contato: " + telefones : null).append(emails != null ? emails + "\n" : null)
                .append(this.dataDeCadastro != null ? "Data de Abertura: " + dtf.print(this.dataDeCadastro) : null)
                .append(this.dataDeCadastro != null ? "Data de Alteração: " + dtf.print(this.dataDeAlteracao) : null).toString();
    }
}

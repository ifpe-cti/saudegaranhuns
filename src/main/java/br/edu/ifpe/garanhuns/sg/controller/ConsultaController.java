/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.Atendente;
import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.AtendenteHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.Prioridade;
import br.edu.ifpe.garanhuns.sg.model.Status;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class ConsultaController implements Serializable {

    private ConsultaHibernate model;
    private Consulta consulta;
    private FacesContext fc;
    private ExternalContext ec;

    @PostConstruct
    public void init() {
        fc = FacesContext.getCurrentInstance();
        ec = fc.getExternalContext();
        model = new ConsultaHibernate();
        consulta = new Consulta();
        consulta.setPaciente(pacienteLogado());
    }

    public ConsultaController() {
    }

    public void cadastrar() {
        consulta.setDataSolicitacao(LocalDate.now());
        consulta.setStatus(Status.AGENDADO);
        model.inserir(consulta);
    }

    public void alterar() {
        model.atualizar(consulta);
    }

    public void cancelar() {
        model.alterarStatusConsulta(consulta, 3);
    }

    public void cancelar(Consulta consulta) {
        model.alterarStatusConsulta(consulta, 3);
    }

    public void alterarStatusAtendido() {
        model.alterarStatusConsulta(consulta, 1);
    }

    public void alterarStatusAtendido(Consulta consulta) {
        model.alterarStatusConsulta(consulta, 1);
    }

    public Consulta buscar(int id) {
        return model.recuperar(id);
    }

    public List<Consulta> buscarTodos() {
        return model.recuperarTodos();
    }

    public List<Consulta> buscarTodasPorPaciente() {
        return model.recuperarConsultasPorPaciente(pacienteLogado());
    }

    public List<Consulta> buscarConsultasDoPostoPorDia() {
        return model.recuperarConsultasDoPostoPorDia(atendenteLogado().getPostoSaude(), LocalDate.now());
    }

    public List<Consulta> buscarConsultasDoDia() {
        return model.recuperarConsultasDoDia(LocalDate.now());
    }

    public List<LocalDate> buscarDatasAgendamento() {
        return model.agendamentoAutomaticoConsulta(consulta.getPaciente().getPostoSaude(), consulta.getEspecialidade());
    }

    public void gerarComprovante() {
        try {
            fc = FacesContext.getCurrentInstance();
            ec = fc.getExternalContext();
            ec.setResponseContentType("application/pdf");
            ec.setResponseHeader("Content-Disposition", "inline; filename=\"dynamic.pdf\"");
            OutputStream output = ec.getResponseOutputStream();
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, output);
            gerarPdf(document, consulta);
            fc.responseComplete();
        } catch (IOException | DocumentException e) {
            System.err.println("Falha ao gerar comprovante. Erro: " + e);
        }
    }

    public void gerarPdf(Document document, Consulta consulta) {
        try {
            document.open();
            Font fontTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Comprovante de agendamento de consulta", fontTitulo);
            Font fontInfo = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Paragraph infoData = new Paragraph("Data do agendamento: " + consulta.getDataAgendamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), fontInfo);
            Paragraph infoNome = new Paragraph("Nome do paciente: " + consulta.getPaciente().getNome(), fontInfo);
            Paragraph infoPosto = new Paragraph("Nome do posto de saúde: " + consulta.getPaciente().getPostoSaude().getNome(), fontInfo);
            document.add(titulo);
            document.add(infoData);
            document.add(infoNome);
            document.add(infoPosto);
            document.close();
        } catch (DocumentException ex) {
            System.err.println("Falha ao gerar pdf. Erro: " + ex);
        }
    }

    public Prioridade[] getPrioridade() {
        return Prioridade.values();
    }

    public Especialidade[] getEspecialidade() {
        return Especialidade.values();
    }

    public Status[] getStatus() {
        return Status.values();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    private Paciente pacienteLogado() {
        Usuario usuarioLogado = (Usuario) ((HttpSession) ec.getSession(true)).getAttribute("usuarioLogado");
        Paciente pacienteLogado = new PacienteHibernate().recuperarPacientePorUsuario(usuarioLogado);
        return pacienteLogado;
    }

    private Atendente atendenteLogado() {
        Usuario usuarioLogado = (Usuario) ((HttpSession) ec.getSession(true)).getAttribute("usuarioLogado");
        Atendente atendenteLogado = new AtendenteHibernate().recuperarAtendentePorUsuario(usuarioLogado);
        return atendenteLogado;
    }

    public void limpar() {
        this.consulta = new Consulta();
        consulta.setPaciente(pacienteLogado());
    }
}

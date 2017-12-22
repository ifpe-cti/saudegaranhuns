/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Prioridade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Status;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
        consulta = new Consulta();
        model = new ConsultaHibernate();
        fc = FacesContext.getCurrentInstance();
        ec = fc.getExternalContext();
    }

    public ConsultaController() {
    }

    public void cadastrar() {
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

    public Consulta buscar(int id) {
        return model.recuperar(id);
    }

    public List<Consulta> buscarTodos() {
        return model.recuperarTodos();
    }

    public void gerarComprovante() {
        try {
            ec.responseReset();
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
            document.add(new Paragraph());
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

    public void limpar() {
        this.consulta = new Consulta();
    }
}

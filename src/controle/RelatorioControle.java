package controle;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import persistencia.Conexao;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import entidades.Cliente;

public class RelatorioControle {

    public void gerarRelatorio(Cliente id){
        String erro = "";
        Integer idCliente = id.getIdCliente(); ;
        String jasper = "C:\\Users\\ytalo\\JaspersoftWorkspace\\Relatorio_Financeiro";

        HashMap <String , Object> param = new HashMap<String, Object>();
        param.put("Cliente",idCliente);

        byte[] bytes = null;

        try {
            JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile(jasper);

            bytes = JasperRunManager.runReportToPdf(relatorio, param , new Conexao().getConnection());

            File arq = new File ("C:\\TEMP",idCliente+".pdf");
            if(arq.exists())
            {
                arq.delete();
            }

            FileOutputStream fl = new FileOutputStream(arq);
            fl.write(bytes);
            fl.flush();
            fl.close();

            Desktop desk = Desktop.getDesktop();
            desk.open(arq);

        } catch (JRException |  IOException  e) {
            erro = e.getMessage();
            System.out.println("Erro na execucao do relatorio:" + erro);
        }

    }

}

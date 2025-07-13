package configuracionjasperreport;

import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author JorgeLPR
 */
public class ConfiguracionJasperreport {

    public ConfiguracionJasperreport() {
    
        try{
        
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/recetario.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, null, new JREmptyDataSource());
            
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
            
        }catch(JRException ex){
            System.out.println(ex.getMessage());
        }
    
    }
    
    public ConfiguracionJasperreport(String title) {
    
        try{
        
            // Crear un mapa de parámetros
            Map<String, Object> parametros = new HashMap<>();

            // Agregar parámetros al mapa (ajusta estos según los parámetros que necesite tu reporte)
            parametros.put("nombreMedico", "Manuel Gonzales");
            parametros.put("especialidadMedico", "Medico General");
            parametros.put("codigoMedico", 12345);
            parametros.put("nombrePaciente", "Medico General");
            parametros.put("direccionPaciente", "Medico General");
            parametros.put("numDocPaciente", 12345678);
            parametros.put("nombreEstablecimiento", "Medico General");
            parametros.put("telefonoEstablecimiento", 1234567);
            //parametros.put("logoConsultorio", "Medico General");
           
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/parameters/recetario.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
            
            
            
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
            
        }catch(JRException ex){
            System.out.println(ex.getMessage());
        }
    
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConfiguracionJasperreport view = new ConfiguracionJasperreport("title");
    }
    
    
    
}

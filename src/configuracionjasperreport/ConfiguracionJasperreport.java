package configuracionjasperreport;

import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConfiguracionJasperreport view = new ConfiguracionJasperreport();
    }
    
}

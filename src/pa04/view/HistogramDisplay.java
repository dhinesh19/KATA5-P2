package pa04.view;

import javax.swing.JPanel;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import pa04.model.Histogram;

public class HistogramDisplay extends ApplicationFrame {
    
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram){
        super("Histograma");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute() {
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel (createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        return chartPanel;
    }
    
    private JFreeChart createChart (DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma de emails",
                "dominio email",
                "nº de emails recibidos",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key: histogram.keySet()){
            dataset.addValue(histogram.get(key), "", key);
        }
        return dataset;
    }
}

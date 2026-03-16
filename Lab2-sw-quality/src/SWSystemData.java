import java.util.ArrayList;
import java.util.HashMap;

public class SWSystemData { 
 
    public static HashMap<String, ArrayList<SWSystem>> getAllSystems() { 
 
        HashMap<String, ArrayList<SWSystem>> map = new HashMap<>(); 
 

        ArrayList<SWSystem> webList = new ArrayList<>(); 
        webList.add(createECommercePlatform()); 
        webList.add(createBankingPortal()); 
        map.put("Web", webList); 
 
    
        ArrayList<SWSystem> mobileList = new ArrayList<>(); 
        mobileList.add(createHealthApp()); 
        map.put("Mobile", mobileList); 
 
        return map; 
    } 
 
 private static SWSystem createECommercePlatform() {
        SWSystem s = new SWSystem("ShopSphere", "Web", "3.2.1");

      
        QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 25.0);
        funcSuit.addCriterion(new Criterion("Functional Completeness Ratio", 50, "higher", 0, 100, "%"));
        funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", 50, "higher", 0, 100, "%"));
        s.addDimension(funcSuit);

        
        QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 25.0);
       reliability.addCriterion(new Criterion("Availability Ratio", 50, "higher", 95, 100, "%"));
        reliability.addCriterion(new Criterion("Defect Density", 50, "lower", 0, 16.8, "defect/KLOC")); 
        s.addDimension(reliability);

        QualityDimension performance = new QualityDimension("Performance Efficiency", "QC.PE", 25.0);
        performance.addCriterion(new Criterion("Response Time", 50, "lower", 0, 880, "ms")); 
        performance.addCriterion(new Criterion("CPU Utilisation Ratio", 50, "lower", 0, 152, "%")); 
        s.addDimension(performance);

        QualityDimension maintainability = new QualityDimension("Maintainability", "QC.MA", 25.0);
        maintainability.addCriterion(new Criterion("Test Coverage Ratio", 50, "higher", 20, 100, "%")); 
        maintainability.addCriterion(new Criterion("Cyclomatic Complexity (avg)", 50, "lower", 1, 21, "score")); 
        s.addDimension(maintainability);

        return s;
    }
 private static SWSystem createBankingPortal() {
        SWSystem bankSystem = new SWSystem("SecureBank Portal", "Web", "2.1.0");

        QualityDimension security = new QualityDimension("Security", "QC.SEC", 100.0);

        security.addCriterion(new Criterion("Security Test Coverage", 50, "higher", 0, 100, "%"));
        security.addCriterion(new Criterion("Vulnerability Count", 50, "lower", 0, 20, "count"));
        
        bankSystem.addDimension(security);

        return bankSystem;
    }


    private static SWSystem createHealthApp() {
        SWSystem healthApp = new SWSystem("FitLife Tracker", "Mobile", "1.0.5");
        QualityDimension usability = new QualityDimension("Usability", "QC.US", 100.0);

        usability.addCriterion(new Criterion("Task Completion Rate", 50, "higher", 0, 100, "%"));
        usability.addCriterion(new Criterion("User Error Rate", 50, "lower", 0, 100, "%"));
        
        healthApp.addDimension(usability);

        return healthApp;
    }
}
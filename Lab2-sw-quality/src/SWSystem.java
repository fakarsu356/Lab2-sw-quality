import java.util.ArrayList;

public class SWSystem {
    private String name; 
    private String category;
    private String version;
    private ArrayList<QualityDimension> dimensionsList;
    public SWSystem(String name,String category,String version){
        dimensionsList=new ArrayList<>();
        this.name=name;
        this.category=category;
        this.version=version;
    }
    public void addDimension(QualityDimension qd){
        if(qd!=null){
            dimensionsList.add(qd);
        }
        else return;
    }
    public double calculateOverallScore(){
        Double totalWeightedScore=0.0;
        Double totalWeights=0.0;
        for(QualityDimension q:dimensionsList){
          totalWeightedScore= (q.calculateDimensionScore()*q.getWeight())+totalWeightedScore;
          totalWeights=totalWeights+q.getWeight();
        }
        return totalWeightedScore/totalWeights;
    }
    public QualityDimension findWeakestDimension(){
       
        QualityDimension weakest;
        weakest=dimensionsList.get(0);
        for(QualityDimension q: dimensionsList){
            if(q.calculateDimensionScore()<weakest.calculateDimensionScore()){
                weakest=q;
            }
        }
        return weakest;
    }
   public void printReport() {
        System.out.println("===");
        System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
        System.out.println("System: " + this.name + " v" + this.version + " (" + this.category + ")");
        System.out.println();

        for (QualityDimension qd : dimensionsList) {
            System.out.printf("--- %s [%s] (Weight: %.0f) ---\n", 
                              qd.getName(), qd.getIsoCode(), qd.getWeight());

            for (Criterion c : qd.getCriteriaList()) {
                String directionText = c.getDirection().equalsIgnoreCase("higher") ? "Higher is better" : "Lower is better";
                
                System.out.printf("  %s: %.1f %s -> Score: %.1f (%s)\n", 
                                  c.getName(), 
                                  c.getMeasuredValue(), 
                                  c.getUnit(), 
                                  c.calculateScore(), 
                                  directionText);
            }
            
            double dimScore = qd.calculateDimensionScore();
            System.out.printf("  >> Dimension Score: %.1f / 5 [%s]\n\n", 
                              dimScore, qd.getQualityLabel(dimScore));
        }

        double overallScore = calculateOverallScore();
       
        System.out.printf("OVERALL QUALITY SCORE: %.1f / 5 [%s]\n\n", 
                          overallScore, QualityDimension.getQualityLabel(overallScore));

        System.out.println("=== GAP ANALYSIS (ISO/IEC 25010) ===");
        QualityDimension weakest = findWeakestDimension();
        
        if (weakest != null) {
            double weakestScore = weakest.calculateDimensionScore();
            double gap = 5.0 - weakestScore; 
            
            System.out.printf("Weakest Characteristic: %s [%s]\n", weakest.getName(), weakest.getIsoCode());
            System.out.printf("Score: %.1f / 5 | Gap: %.1f\n", weakestScore, gap);
            System.out.printf("Level: %s\n", weakest.getQualityLabel(weakestScore));
            System.out.println(">> This characteristic requires the most improvement.");
        }
    }
   public String getName() {
    return name;
   }
   public void setName(String name) {
    this.name = name;
   }
   public String getCategory() {
    return category;
   }
   public void setCategory(String category) {
    this.category = category;
   }
   public String getVersion() {
    return version;
   }
   public void setVersion(String version) {
    this.version = version;
   }
   public ArrayList<QualityDimension> getDimensionsList() {
    return dimensionsList;
   }
   public void setDimensionsList(ArrayList<QualityDimension> dimensionsList) {
    this.dimensionsList = dimensionsList;
   }
}

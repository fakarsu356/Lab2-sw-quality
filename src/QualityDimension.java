import java.util.ArrayList;

public class QualityDimension {
  private String  name;
  private String isoCode;
  private Double weight;
  private ArrayList<Criterion> criteriaList;
  public QualityDimension(String name, String isoCode, Double weight) {
    this.name = name;
    this.isoCode = isoCode;
    this.weight = weight;
    this.criteriaList =new ArrayList<>();
  }
  public void addCriterion(Criterion c){
    if(c==null) return ;
    criteriaList.add(c);
  }
 public double calculateDimensionScore() {
        double totalWeightedScore = 0.0;
        double totalWeights = 0.0;
        
        for (Criterion c : criteriaList) {
            totalWeightedScore += (c.calculateScore() * c.getWeight());
            totalWeights += c.getWeight();
        }
        
        if (totalWeights == 0) return 0.0;
        return totalWeightedScore / totalWeights;
    }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getIsoCode() {
    return isoCode;
  }
  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }
  public Double getWeight() {
    return weight;
  }
  public void setWeight(Double weight) {
    this.weight = weight;
  }
  public ArrayList<Criterion> getCriteriaList() {
    return criteriaList;
  }
  public void setCriteriaList(ArrayList<Criterion> criteriaList) {
    this.criteriaList = criteriaList;
  }
  public static String getQualityLabel(double score) {
        if (score >= 4.5) return "Excellent Quality";
        if (score >= 3.5) return "Good Quality";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor Quality";
    }
  public Double calculateQualityGap(){
  return 5-calculateQualityGap();
  }
}

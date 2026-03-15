public class Criterion {
    private String name;
private double weight;
 private String direction;
 private double minValue;   
 private double maxValue;
 private String unit;
private double measuredValue;
public Criterion(String name, double weight, String direction, double minValue, double maxValue, String unit) {
    this.name = name;
    this.weight = weight;
    this.direction = direction;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.unit = unit;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public double getWeight() {
    return weight;
}
public void setWeight(double weight) {
    this.weight = weight;
}
public String getDirection() {
    return direction;
}
public void setDirection(String direction) {
    this.direction = direction;
}
public double getMinValue() {
    return minValue;
}
public void setMinValue(double minValue) {
    this.minValue = minValue;
}
public double getMaxValue() {
    return maxValue;
}
public void setMaxValue(double maxValue) {
    this.maxValue = maxValue;
}
public String getUnit() {
    return unit;
}
public void setUnit(String unit) {
    this.unit = unit;
}
public double getMeasuredValue() {
    return measuredValue;
}
public void setMeasuredValue(double measuredValue) {
    this.measuredValue = measuredValue;
}
public double calculateScore(){
    double score=0.0;
    if(direction.equals("higher")){
        score = 1 + (measuredValue - minValue) / (maxValue - minValue) * 4;
    }
    else{
        score = 5 - (measuredValue - minValue) / (maxValue - minValue) * 4;
    }
    if(score>5.0){
        score=5.0;
    }
    else if(score<1.0){
        score=1.0;
    }
    score = Math.round(score * 2) / 2.0;

    return score;
}
}

package sheet01;

import java.util.Map;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * The full decision tree learning algorithm.
 */
public class Exercise_01 {
	
  public static int num_col(Dataset dataset, NominalAttribute classAttribute) {
	 
	 for(int i=0; i<dataset.getRows().get(0).values.length; i++) {
		 if (dataset.getRows().get(0).values[i] == classAttribute.getName())
			 return i;
	 }
	 
	 return -1;
  }
  
  public static int proportion(Dataset dataset, NominalAttribute classAttribute, String value) {
	 int prop = 0;
	 
	 for(Dataset.Row e: dataset.getRows())
		 if (e.values[num_col(dataset, classAttribute)] == value)
		 		prop++;
	 
	 return prop;
  }

  /**
   * Computes the entropy on a subset of the dataset relative to
   * the classification by <code>classAttribute</code>.
   *
   * @param dataset the entire dataset
   * @param subsetIndices indices of instances that constitute a subset of
   *   the dataset
   * @param classAttribute the attribute by which the instances are classified
   * @return entropy of the subset relative to <code>classAttribute</code>-wise
   *   classification
   *
   */
  public static double entropyOnSubset(
    Dataset dataset,
    int[] subsetIndices,
    NominalAttribute classAttribute
  ) {
    double ent = 0;
    
    //entsprechende zeilen aus subsetIndices extrahieren
    Dataset classAttributeSet = new Dataset();
    for(int e: subsetIndices) {
    	classAttributeSet.addRow(dataset.getRows().get(e).values);
    }
    
    
    for(String e: classAttribute.getValues()) {
    	int p = proportion(classAttributeSet, classAttribute, e);
    	ent += (-p*(Math.log(p)/Math.log(2)));
    }
    
    return ent;
  }

  /**
   * Computes the information gain of the attribute
   * <code>partitioningAttribute</code> on the subset of the dataset.
   *
   * @param dataset the entire dataset
   * @param subsetIndices indices of instances that constitute a subset of
   *   the dataset
   * @param classAttribute the attribute by which the instances are classified
   * @param partitioningAttribute the attribute by which the subset could be
   *   further partitioned
   * @return expected gain in entropy that we get when we partition the
   *   subset by the attribute <code>partitioningAttribute</code>
   */
  public static double informationGain(
    Dataset dataset,
    int[] subsetIndices,
    NominalAttribute classAttribute,
    NominalAttribute partitioningAttribute
  ) { 
	  double gain = entropyOnSubset(dataset, subsetIndices, classAttribute);
	  
	  Dataset classAttributeSet = new Dataset();
	  for(int e: subsetIndices) {
	   	classAttributeSet.addRow(dataset.getRows().get(e).values);
	  }
	  
	  for(String v: partitioningAttribute.getValues()) {
		  //instances that take value v at attribute A
		  Dataset Sv = new Dataset();  
		  for(Dataset.Row s: classAttributeSet.getRows())
			  if (s.values[num_col(dataset, partitioningAttribute)] == v)
			 		Sv.addRow(s.values);;
		  
		  gain -= entropyOnSubset(Sv, subsetIndices, classAttribute)*(Sv.getRows().size())/(classAttributeSet.getRows().size());
	  }
	  
	  return gain;
  }
  
  
/*
  *//**
   * Constructs an inner node of the decision tree.
   *
   * @param attr which attribute to use for the decision
   * @param children for each value of the attribute, a child decision tree
   * @return decision tree with <code>attr</code> as root label.
   *//*
  public static DecisionTree branch(
    NominalAttribute attr,
    Map<NominalValue, DecisionTree> children
  ) {
    
  }

  *//**
   * Constructs a leaf node of the decision tree.
   *
   * @param value the returned value of the target attribute
   * @return leaf of the decision tree that returns a constant value for
   *   all instances.
   *//*
  public static DecisionTree leaf(final NominalValue value) {
    
  }

  *//**
   * Builds decision tree for a subset of the dataset,
   * considers only the attributes that are still available.
   *
   * Implement either this or the `trainModelOnSubset` method.
   * This one should be more efficient, because it does not reconsider
   * the same attributes multiple times, once they have been used in
   * a node above.
   *
   * @param dataset the entire training set
   * @param subsetIndices indices that specify a subset of the training set
   * @param availableDecisionAttributes
   *   attributes that have not been used in the nodes above
   * @param classAttribute the target attribute that should be predicted
   * @return decision tree that can classify instances similar to those in the
   *   dataset, and returns nominal values of the <code>classAttribute</code>.
   *//*
  public static DecisionTree trainModelOnSubset(
    Dataset dataset,
    int[] subsetIndices,
    List<NominalAttribute> availableDecisionAttributes,
    NominalAttribute classAttribute
  ) {
 
  }

  *//**
   * Builds decision tree for the entire training set.
   *
   * @param dataset the entire training set
   * @param classAttribute the target attribute
   * @return decision tree that can classify instances similar to those in the
   *   dataset, and returns nominal values of the <code>classAttribute</code>
   *//*
  public static DecisionTree trainModel(
    Dataset dataset,
    NominalAttribute classAttribute
  ) {
    
  }

  *//**
   * Splits a dataset into two disjoint subsets: a training set, and a test set.
   *
   * @param dataset the entire dataset
   * @param trainProportion floating point number between 0 and 1, specifies
   *   the proportion of the training set (0 = no training set, 0.5 = half of
   *   instances is training set, 0.9 = 90% are training set, etc.)
   * @return List with exactly two datasets: first is the training set,
   *   second is the test set
   *//*
  public static List<Dataset> splitTrainTest(
    Dataset dataset,
    double trainProportion
  ) {
    
  }


  *//**
   * Evaluates a decision tree training method on a test set.
   *
   * The class attribute is passed explicitly.
   *
   * @param trainingMethod a function that takes a training set,
   *   a target attribute ("class attribute"), and outputs a decision tree
   * @param dataset the entire dataset
   *   (contains both training and test instances)
   * @param classAttribute the class attribute
   * @param trainProportion relative size of the training set to use during
   *   the evaluation.
   * @return percentage of correctly classified instances
   *//*
  public static double evaluate(
    BiFunction<Dataset, NominalAttribute, DecisionTree> trainingMethod,
    Dataset dataset,
    NominalAttribute classAttribute,
    double trainProportion
  ) {
    
  }
*/
}


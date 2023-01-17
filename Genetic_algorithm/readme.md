The goal of the algorithm is to find an approximate solution to a problem by making “educated guesses”.  
The algorithm will work on an Entity class.  
The algorithm takes a number of arguments. Most of these are lambdas(FunctionalInterfaces).  
First, populationCount entities are created using createRandomEntity().  
Then, doCrossover(Entity e1, Entity e2) is invoked on two random entities. This is repeated crossoverCount times.  
Then, mutateEntity(Entity e) is invoked on a randomly selected entity.  
The method, with mutationProbability probability will change the entity in some way.  
Usually, mutationProbability is quite low, perhaps 0.1%.  
Then, calculateFitness(Entity e) calculates the fitness of each entity.  
We only keep the best pruneCount entities; we fill up the remaining places with createRandomEntity().  
So far, we have generated a new generation out of the previous one.  
We repeat these steps generationCount times, then return with the entity with the highest finess value of the last generation.  

To test the Algortihm:

- Write some text into a String, this will be the code to crack.
- You may limit your strings to lowercase English characters.
- The Entity class will contain a String now.
- The fitness value of an Entity shows how far its String is from the code.
- Compute the fitness of an Entity like this: add the difference of the lengths of the strings, plus the number of differing character positions.
- With this formula, the best fitness value is 0, which is reached when we have reached the code.
- A crossover between two Entitys splits both strings at random positions, and joins their first and second parts.
- A mutation changes a random character in the string of the Entity.
- Run the genetic algorithm a couple of times, and see whether it can crack the code.
- Experiment with different values for the parameters.

/*
design a zoo with different types of animals and cages(type, size), some of them cannot be in same cage. 
how to represent relationship? what if lion eat 1 million different animals?
*/

The main objects that immediately comes to mind are : zoo, cages animals. 
The relation ships between the objects are: 

Zoo contains cages 
Zoo contains animals 
Cage contains animals. 

So one way to represent the zoo in uml is : 
zoo contains cages 
cage contain animals 

Another way to represent the zoo in uml is 
We can group animals by their type (for instancetype=lion contains the list of lion objects) 

AnimalType 
LinkedList<Animal> animals 

I think zoo should be like this 
zoo 
List <cage> 
List <AnimalType> 
Where list can be replaced by search tree or other collection. 

cage 
size 
type 
List<animal> 

Now the question about the lion is very interesting. 
I think the point is that an animal can not be at the same cage with other type of animals that he eats. 
For instance we can devidethe world of animals into two complement groups: 
Those that the lion eats and those which he does not eat. In this question the lion eats million of animals. 
Now lets say there are one million and ten types of animals that can be in the zoo. 
In this case we would prefer to store only the ten animals that the lion does not eat. 
On the other hand if we look at a cow for instance which is vegetarian we would represent the list of animals that it eats with null. 
So this discutiion lead us to add binary member to the class of animal, bCanBeAtTheSameCage, when bCanBeAtTheSameCage = true means 
we represent a list of animals that can be in the same cage like this animal. If bCanBeAtTheSameCage = false means we represent 
in the least those animals who can not be in the same cage with this animal. 

Animal 
bCanBeAtTheSameCage 
List<Animal> TogheterInCage

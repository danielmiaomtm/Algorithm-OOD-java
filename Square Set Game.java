class Card () {
  private int number;
  private int color;
  private int shading; 
  private int symbol;
  Card (int number, int color, int shading, int symbol) {
    this.number = number;
    this.color = color;
    this.shading = shading;
    this.symbol = symbol;
  }
}


public List<Card> InitCards () {
  List<Card> cards = new ArrayList<>();
  for (int num = 0; num < 3; num++) {
    for (int col = 0; col < 3; col++) {
      for (int shade = 0; shade < 3; shade++) {
        for (int sym = 0; sym < 3; sym++) {
          cards.add(new Card(num, col, share, sym));
        }
      }
    }
  }
  shuffle(cards);
  return cards;
}

public void shuffle (List<Card> cards) {
  Random rand = new Random();
  for (int i = cards.length - 1; i >= 0; i--) {
    int index = rand.next(cards.length);
    Card temp = cards.get(i);
    cards.set(i, cards.get(index));
    cards.set(index, temp);
  }
}


public boolean isSet (Card a, Card b, Card c) {
  // either all card number is same or all card is not same
  if (!(  ((a.number == b.number) && (b.number == c.number)) ||
          ((a.number != b.number) && (a.number != c.number) && 
          (b.number != c.number))
       )
     ) {
      return false;
  }
  //either one card symbol is same
  if (!((a.symbol == b.symbol) && (b.symbol == c.symbol) ||
          (a.symbol != b.symbol) && (a.symbol != c.symbol) && (b.symbol != c.symbol))) {
      return false;
  }
  if (!((a.shading == b.shading) && (b.shading == c.shading) ||
          (a.shading != b.shading) && (a.shading != c.shading) && (b.shading != c.shading))) {
      return false;
  }
  if (!((a.colour == b.colour) && (b.colour == c.colour) ||
          (a.colour != b.colour) && (a.colour != c.colour) && (b.colour != c.colour))) {
      return false;
  }
  return true;
}



 List<List<Card>> getAllSets(List<Card> cards, boolean findOnlyFirstSet) {
     List<List<Card>> result = new ArrayList<>();
     if (cards == null) return result;
     int size = cards.size();
     // get three cards
     for (int ai = 0; ai < size; ai++) {
         Card a = cards.get(ai);
         for (int bi = ai + 1; bi < size; bi++) {
             Card b = cards.get(bi);
             for (int ci = bi + 1; ci < size; ci++) {
                 Card c = cards.get(ci);
                 // if they are set, then add into result
                 if (isSet(a, b, c)) {
                     ArrayList<Card> set = new ArrayList<Card>();
                     set.add(a);
                     set.add(b);
                     set.add(c);
                     result.add(set);
                     if (findOnlyFirstSet) return result;
                 }
             }
         }
     }
     return result;
 }


List<Card> getSet(List<List<Card>> sets, int selectionMode) {
    if (sets.size() == 0) return new ArrayList<Card>();
    
    if (sets.size() == 1 || selectionMode == 1) return sets.get(0); // When only one, or if selection mode is "First found"
    
    List<List<Card>> pickFromThese = sets;
    
    if (selectionMode == 3) {
        pickFromThese = getMostSameSets(sets);
    }
     // pick randomly
    int randIndex = random.nextInt(pickFromThese.size());
    return pickFromThese.get(randIndex);
}

private static String selectionModeName(int selectionMode) {
    switch (selectionMode) {
        case 1: return "First found Set";
        case 2: return "Random among available Sets";
        case 3: return "Random among 'most similar' Sets";
        default: return "Invalid";
    }
}
    
    

List<List<Card>> getMostSameSets(List<List<Card>> sets) {
    int bestSameProperties = 0;
    List<List<Card>> bestSets = new ArrayList<ArrayList<Card>>();
    for (List<Card> set : sets) {
        int sameProperties = getSameProperties(set);
        if (sameProperties > bestSameProperties) { // new best value
            bestSets.clear();
            bestSets.add(set);
            bestSameProperties = sameProperties;
        } else if (sameProperties == bestSameProperties) {
            bestSets.add(set);
        }  else {
            // this set is worse than currently best, just skip it
        }
    }
    return bestSets;
}

int getSameProperties(List<Card> set) {
    if (set.size() != 3) throw new IllegalArgumentException("the set must contain exactly 3 cards - got " + set.size());
    Card a = set.get(0);
    Card b = set.get(1);
    Card c = set.get(2);
    int sameProperties = 0;
    if (a.number == b.number && b.number == c.number) sameProperties++;
    if (a.symbol == b.symbol && b.symbol == c.symbol) sameProperties++;
    if (a.shading == b.shading && b.shading == c.shading) sameProperties++;
    if (a.colour == b.colour && b.colour == c.colour) sameProperties++;
    return sameProperties;
}




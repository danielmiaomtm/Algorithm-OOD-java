enum AttackResponse {
        HIT, MISS, SUNK, END
}

    class Ship {
        private List<Coordination> parts;
        GameBoard board;

        void addPart(Coordination coor) {
            parts.add(coor);
        }

        void removePart(Coordination coor) {
            parts.remove(coor);
        }
        boolean hasSunk() {
            return parts == null || parts.size() == 0;
        }
    }

    class Coordination {
        private int x;
        private int y;
    }

    class Player {
        int id;
        GameBoard board;

        AttackResponse Attack(GameBoard rivalBoard, Coordination shot) {
            if(!rivalBoard.checkCoordinationInfo(shot)) {
                return AttackResponse.MISS;
            }
            else {
                Ship hittedShip = rivalBoard.getRelatedShip(shot);
                rivalBoard.removeRelation(shot);
                if(!rivalBoard.isShipSunk(hittedShip)) {
                    return AttackResponse.HIT;
                }
                else if(!rivalBoard.isGameEnd()){
                    return AttackResponse.SUNK;
                }
                else {
                    return AttackResponse.END;
                }
            }
        }

    }

    class GameBoard {
        //List<Ship> ships;
        //boolean[][] hasPart;
        private HashMap<Coordination, Ship> relations;
        private Player player;

        boolean checkCoordinationInfo(Coordination coor) {
            return relations.containsKey(coor);
        }

        void removeRelation(Coordination coor) {
            relations.remove(coor);
        }

        Ship getRelatedShip(Coordination coor) throws Exception {
            if(relations.containsKey(coor)){
                return relations.get(coor);
            }
            else {                
                throw new Exception(&quot;wrong coordination!&quot;);
            }
        }
        boolean isShipSunk(Ship ship) {
            return !relations.containsValue(ship);
        }

        boolean isGameEnd() {
            return relations == null || relations.size() == 0;
        }
    }

import greenfoot.*; 

public class Magician extends Actor
{
    private GridProxy gridProxy;
   /// private PlayerWorldButton  nextButton;
    private BackCurtain backCurtain; 

    public Magician(GridProxy grid/*, PlayerWorldButton nextButton*/, BackCurtain backCurtain) {
        this.gridProxy  = grid;
       // this.nextButton = nextButton;
        this.backCurtain = backCurtain; 
    }

    public void operateGrid() {
        System.out.println("in opetation  gridProxy.isExpanded() "+ gridProxy.isExpanded());
        if(!gridProxy.isExpanded()) {
            World world = getWorld();
            Message message = new TempMessage("Hmm, let's make it more chanllenging!");
            world.addObject(message, 400, 150);
            System.out.println("about to expand");
            gridProxy.expandGrid();
            System.out.println("Blow grid");
            fillErrorDetection(); 
            this.gridProxy.setExpanded(true);
        }
      //  System.out.println("is presseend " + button.isPressed());
        Greenfoot.delay(100);
    }

    public void act() {
        
    }

    public void fillErrorDetection() {
       int countableGridSize = gridProxy.getSize()-1;
       Card[][] cardGrid = gridProxy.getCardGrid(); 
        int r = 0;
        for(int row = 0; row < countableGridSize ; row++){
            int count = 0;
            for(int col = 0; col < countableGridSize ; col++){
                // iterate through rows of matrix to count face up cards;
                // 
                if(cardGrid[row][col].isFacingUp() == true){
                    count++;
                    r =col ;
                }
                // After loop ends, we have finished counting face up cards in columns. If the count is even, the card for that column in 
                // expanded grid will be face down. If it is odd, the face up card will be added.
            }
           System.out.println(" faceup count "+count);
            if(count % 2 != 0){
                System.out.println("RRRR flipping as odd faceups row "+ row + "+ col - "+countableGridSize);
                cardGrid[row][countableGridSize].flipCard();
            }
             
        }
        
        
        for(int col = 0; col < countableGridSize ; col++){
            int count = 0;
            for(int row = 0; row < countableGridSize ; row++){
                // iterate through rows of matrix to count face up cards;
                if(cardGrid[row][col].isFacingUp() == true){
                    count++;
                }
                // After loop ends, we have finished counting face up cards in rows. If the count is even, the card for that row in expanded
                // grid will be face down. If it is odd, the face up card will be added.
            }
            //System.out.println("WW on col "+i+" faceup count "+count);
            if(count % 2 != 0){
               System.out.println("RRRR flipping as odd faceups row "+ 0 + "+ col - "+countableGridSize);
                cardGrid[countableGridSize][col].flipCard();
            }
        }
    }

    public Card trick(){
        Card[][] cardGrid = gridProxy.getCardGrid(); 
        int gridSize = gridProxy.getSize();
        int faultRow, faultColumn;
        int colFacingUpCardsCount, rowFacingUpCardsCount,i,j;
        i = j = faultRow = faultColumn = colFacingUpCardsCount = rowFacingUpCardsCount = 0;
        // first go through rows to get which row has the fault;
        for(i=0; i<gridSize;i++){
            for(j=0; j< gridSize; j++){
                //if rowCard facing up, then count it
                if(cardGrid[i][j].isFacingUp()){
                    rowFacingUpCardsCount++;
                }
            }
            if(rowFacingUpCardsCount %2 != 0){
                faultRow = i;
                break;
            }
            rowFacingUpCardsCount = 0;    
        } 

        for(i=0; i<gridSize;i++){
            for(j=0; j< gridSize; j++){
                //if ColumnCard facing up, then count it
                if(cardGrid[j][i].isFacingUp()){
                    colFacingUpCardsCount++;
                }
            }
            if(colFacingUpCardsCount %2 != 0){
                faultColumn = i;
                break;
            }
            colFacingUpCardsCount = 0;    
        } 
        System.out.println("fault at "+ faultColumn +" "+faultRow);
        Card flippedCard = cardGrid[faultRow][faultColumn];
        return flippedCard;
    }
}
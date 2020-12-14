/**
 * 
 * NAME:		Matthew Hunt
 * PROJECT:	    HW 3
 * COURSE:		CS 232
 * INSTRUCTOR:	Chen
 * DUE DATE:	Feb 2, 2017 at 1:30pm
 * 
 **/
 
 /**
  * 
  * 1. Besides 4 × 4 (which are Game of Fifteen’s dimensions), what other dimensions does the framework allow?
  * 
  * 3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9
  * 
  * 2. With what sort of data structure is the game’s board represented?
  * 
  * Two dimensional int array
  * 
  * 3. What function is called to greet the player at game’s start?
  * 
  * void greet(void);
  * 
  * 4. What functions do you apparently need to implement?
  * 
  * void init(void);
  * void draw(void);
  * bool move(int tile);
  * bool won(void);
  * 
  **/
  
 /**
 * fifteen.c
 *
 * Computer Science 50
 * Problem Set 3
 *
 * Implements Game of Fifteen (generalized to d x d).
 *
 * Usage: fifteen d
 *
 * whereby the board's dimensions are to be d x d,
 * where d must be in [DIM_MIN,DIM_MAX]
 *
 * Note that usleep is obsolete, but it offers more granularity than
 * sleep and is simpler to use than nanosleep; `man usleep` for more.
 **/
 
#define _XOPEN_SOURCE 500

#include <cs50.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// constants
#define DIM_MIN 3
#define DIM_MAX 9

// board
int board[DIM_MAX][DIM_MAX];

// dimensions
int d;

// prototypes
void clear(void);
void greet(void);
void init(void);
void draw(void);
bool move(int tile);
bool won(void);

int main(int argc, string argv[])
{
    // ensure proper usage
    if (argc != 2)
    {
        printf("Usage: fifteen d\n");
        return 1;
    }

    // ensure valid dimensions
    d = atoi(argv[1]);
    if (d < DIM_MIN || d > DIM_MAX)
    {
        printf("Board must be between %i x %i and %i x %i, inclusive.\n",
            DIM_MIN, DIM_MIN, DIM_MAX, DIM_MAX);
        return 2;
    }

    // open log
    FILE* file = fopen("log.txt", "w");
    if (file == NULL)
    {
        return 3;
    }

    // greet user with instructions
    greet();

    // initialize the board
    init();

    // accept moves until game is won
    while (true)
    {
        // clear the screen
        clear();

        // draw the current state of the board
        draw();

        // log the current state of the board (for testing)
        for (int i = 0; i < d; i++)
        {
            for (int j = 0; j < d; j++)
            {
                fprintf(file, "%i", board[i][j]);
                if (j < d - 1)
                {
                    fprintf(file, "|");
                }
            }
            fprintf(file, "\n");
        }
        fflush(file);

        // check for win
        if (won())
        {
            printf("ftw!\n");
            break;
        }

        // prompt for move
        printf("Tile to move: ");
        int tile = GetInt();
        
        // quit if user inputs 0 (for testing)
        if (tile == 0)
        {
            break;
        }

        // log move (for testing)
        fprintf(file, "%i\n", tile);
        fflush(file);

        // move if possible, else report illegality
        if (!move(tile))
        {
            printf("\nIllegal move.\n");
            usleep(500000);
        }

        // sleep thread for animation's sake
        usleep(500000);
    }
    
    // close log
    fclose(file);

    // success
    return 0;
}

/**
 * Clears screen using ANSI escape sequences.
 */
void clear(void)
{
    printf("\033[2J");
    printf("\033[%d;%dH", 0, 0);
}

/**
 * Greets player.
 */
void greet(void)
{
    clear();
    printf("WELCOME TO GAME OF FIFTEEN\n");
    usleep(2000000);
}

/**
 * Initializes the game's board with tiles numbered 1 through d*d - 1
 * (i.e., fills 2D array with values but does not actually print them).  
 */
void init(void)
{
    // calculate the amount of numbers on the board which is the
    // dimension^2 - 1 ans store that value in count
    int count = d*d-1;
    
    // loop through each row
    for (int i = 0; i < d; i++){
        
        // loop thorugh each column
        for (int j = 0; j < d; j++){
            // store the count at the current row and index
            // and then subtract one from the count
            board[i][j] = count--;
        }
        
    }
    
    // check if the board dimensions are even
    if (!(d%2)){
        
        // swap numbers 1 and two on the board
        int temp = board[d-1][d-2];
        board[d-1][d-2] = board[d-1][d-3];
        board[d-1][d-3] = temp;
        
    }
}

/**
 * Prints the board in its current state.
 */
void draw(void)
{
    
    // loop through each row
    for (int i = 0; i < d; i++){
        
        // skip two lines on the console
        printf("\n\n");
        
        // loop through each column
        for (int j = 0; j < d; j++){
            
            // check if current item is 0
            if (board[i][j]==0){
                
                // replace the 0 with an underscore and
                // continue the current for loop
                printf("_\t");
                continue;
            }
            
            // print the current item to the console
            printf("%d\t", board[i][j]);
        }
        
    }
    
    // skip two lines on the console
    printf("\n\n");
}

/**
 * If tile borders empty space, moves tile and returns true, else
 * returns false. 
 */
bool move(int tile)
{
    // declare arrays to hold the index of the tile
    // the user wants to move and the index of the empty tile 
    int indexOfTile[2];
    int indexOfBlankTile[2];
    
    // loop through each row
    for (int i = 0; i < d; i++){
        
        // loop through each column
        for (int j = 0; j < d; j++){
            
            // check if item is the tile the user wants to move
            if (board[i][j] == tile){
                
                // store the index of that tile
                indexOfTile[0] = i;
                indexOfTile[1] = j;
                
            }
            
            // check if item is the empty tile
            if (board[i][j] == 0){
                
                // store the index of the empty tile
                indexOfBlankTile[0] = i;
                indexOfBlankTile[1] = j;
                
            }
        }
    }
    
    // check if the tile the user selected is to the right left above bellow the empty tile
    if(
        // to the left
        (indexOfTile[0] == indexOfBlankTile[0] && indexOfTile[1] == (indexOfBlankTile[1] - 1)) ||
        // to the right
        (indexOfTile[0] == indexOfBlankTile[0] && indexOfTile[1] == (indexOfBlankTile[1] + 1)) ||
         // above
        (indexOfTile[0] == (indexOfBlankTile[0]-1) && indexOfTile[1] == (indexOfBlankTile[1])) ||
        // bellow
        (indexOfTile[0] == (indexOfBlankTile[0]+1) && indexOfTile[1] == (indexOfBlankTile[1])))
    {
        // swap the tiles
        int temp = board[indexOfTile[0]][indexOfTile[1]];
        board[indexOfTile[0]][indexOfTile[1]] = board[indexOfBlankTile[0]][indexOfBlankTile[1]];
        board[indexOfBlankTile[0]][indexOfBlankTile[1]] = temp;
        return true;
    } else{
        return false;     
    }
   
}

/**
 * Returns true if game is won (i.e., board is in winning configuration), 
 * else false.
 */
bool won(void)
{
    // holds the count to be used to see if numbers are in order
    int count = 1;
    
    // loop through each row
    for (int i = 0; i < d; i++){
        
        // loop through each column
        for (int j = 0; j < d; j++){
            
            // check if current item is the last item
            if (i==d-1 && j== d-1){
                break;
            }
            
            // check if current item is not the same as count
            if (board[i][j] != count){
                // user has not won yet so return false
                return false;
            }
            
            // increase count by 1
            count++;
        }
    }
   
    // user has won so return true
    return true;
}

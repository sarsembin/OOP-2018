package Problem_4;

public class Player implements Moveable{
    protected double player_pos_x;
    protected double player_pos_y;
    public Player(){
        player_pos_x = 0;
        player_pos_y = 0;
    }
    public Player(double player_pos_x, double player_pos_y){
        this.player_pos_x = player_pos_x;
        this.player_pos_y = player_pos_y;
    }

    @Override
    public void move(char button) {
        switch (button){
            case 'a': player_pos_x--; break;
            case 'd': player_pos_x++; break;
        }
    }

    @Override
    public void jump() {
        player_pos_y += 5;
    }
}

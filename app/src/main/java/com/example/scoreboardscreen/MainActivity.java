package com.example.scoreboardscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button zero, one, two, three, four, five, six, more, undo, redo, extras;
    TextView score, wickets, team_name, innings, over, over_balls, crr;
    TableRow player_view_1, player_vew_2;
    TextView first_batsman_name, player_status1, first_batsman_runs, first_batsman_balls, first_batsman_fours, first_batsman_sixes, first_batsman_sr;
    TextView second_batsman_name, player_status2, second_batsman_runs, second_batsman_balls, second_batsman_fours, second_batsman_sixes, second_batsman_sr;
    TextView bowler_name, bowler_overs, bowler_madens, bowler_runs, bowler_wickets, bowler_er, bowler_over_balls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "called", Toast.LENGTH_SHORT).show();
        findViews();
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        more.setOnClickListener(this);
        undo.setOnClickListener(this);
        redo.setOnClickListener(this);
        extras.setOnClickListener(this);
    }

    private void findViews() {
        zero = findViewById(R.id.zero_score);

        one = findViewById(R.id.one_score);
        one.setOnClickListener(this);
        two = findViewById(R.id.two_score);
        two.setOnClickListener(this);
        three = findViewById(R.id.three_score);
        four = findViewById(R.id.four_score);
        five = findViewById(R.id.five_score);
        six = findViewById(R.id.six_score);
        more = findViewById(R.id.more_score);
        undo = findViewById(R.id.undo_score);
        redo = findViewById(R.id.redo_score);
        extras = findViewById(R.id.extras_score);

        score = findViewById(R.id.main_score);
        wickets = findViewById(R.id.main_wickets);
        team_name = findViewById(R.id.main_team_name);
        innings = findViewById(R.id.main_innings);
        over = findViewById(R.id.main_over);
        over_balls = findViewById(R.id.main_over_balls);
        crr = findViewById(R.id.main_current_run_rate);
       /* TextView player_view_1,player_vew_2;
        TextView first_batsman_name,player_status1,first_batsman_runs,first_batsman_balls,first_batsman_fours,first_batsman_sixes,first_batsman_sr;
        TextView second_batsman_name,player_status2,second_batsman_runs,second_batsman_balls,second_batsman_fours,second_batsman_sixes,second_batsman_sr;
        TextView bowler_name,bowler_overs,bowler_madens,bowler_runs,bowler_wickets,bowler_er;
*/
        player_view_1 = findViewById(R.id.first_batsman_view);
        player_vew_2 = findViewById(R.id.second_batsman_view);

        first_batsman_name = findViewById(R.id.first_batsman_name);
        player_status1 = findViewById(R.id.play_status1);
        first_batsman_runs = findViewById(R.id.first_batsman_runs);
        first_batsman_balls = findViewById(R.id.first_batsman_balls);
        first_batsman_fours = findViewById(R.id.first_batsman_fours);
        first_batsman_sixes = findViewById(R.id.first_batsman_sixes);
        first_batsman_sr = findViewById(R.id.first_batsman_sr);

        second_batsman_name = findViewById(R.id.second_batsman_name);
        player_status2 = findViewById(R.id.play_status2);
        second_batsman_runs = findViewById(R.id.second_batsman_runs);
        second_batsman_balls = findViewById(R.id.second_batsman_balls);
        second_batsman_fours = findViewById(R.id.second_batsman_fours);
        second_batsman_sixes = findViewById(R.id.second_batsman_sixes);
        second_batsman_sr = findViewById(R.id.second_batsman_sr);

        bowler_name = findViewById(R.id.bowler_name);
        bowler_overs = findViewById(R.id.bowler_over);
        bowler_over_balls = findViewById(R.id.bowler_over_balls);
        bowler_madens = findViewById(R.id.bowler_madens);
        bowler_runs = findViewById(R.id.bowler_runs);
        bowler_wickets = findViewById(R.id.bowler_wickets);
        bowler_er = findViewById(R.id.bowler_er);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.zero_score:
                updateZeroScore();
                break;
            case R.id.one_score:
                updateOneScore(1);
                break;
            case R.id.two_score:
                updateOneScore(2);
                break;
            case R.id.three_score:
                updateOneScore(3);
                break;
            case R.id.four_score:
                updateOneScore(4);
                break;
            case R.id.five_score:
                updateOneScore(5);
                break;
            case R.id.six_score:
                updateOneScore(6);
                break;
            case R.id.more_score:
                break;
            case R.id.undo_score:
                break;
            case R.id.redo_score:
                break;
            case R.id.extras_score:
                break;

        }
    }

    private void swapBatsman(){
        float b1x = player_view_1.getX();
        float b2x = player_vew_2.getX();
        float b1y = player_view_1.getY();
        float b2y = player_vew_2.getY();

        player_view_1.setX(b2x);
        player_view_1.setY(b2y);

        player_vew_2.setX(b1x);
        player_vew_2.setY(b1y);

    }
    private void updateOneScore(int n) {
        switch (n) {
            case 0: {
                updateOver();
                break;
            }
            case 1: {

                int mScore = Integer.parseInt(score.getText().toString());
                int bowler_run = Integer.parseInt(bowler_runs.getText().toString());
                bowler_run += 1;
                bowler_runs.setText("" + bowler_run);
                mScore += 1;
                score.setText("" + mScore);
                updateOver();
                break;
            }
            case 2: {

                int mScore = Integer.parseInt(score.getText().toString());
                int bowler_run = Integer.parseInt(bowler_runs.getText().toString());
                bowler_run += 2;
                bowler_runs.setText("" + bowler_run);
                mScore += 2;
                score.setText("" + mScore);
                updateOver();
                break;
            }
            case 3: {
                int mScore = Integer.parseInt(score.getText().toString());
                int bowler_run = Integer.parseInt(bowler_runs.getText().toString());
                bowler_run += 3;
                bowler_runs.setText("" + bowler_run);
                mScore += 3;
                score.setText("" + mScore);
                updateOver();
                break;
            }
            case 4: {
                int mScore = Integer.parseInt(score.getText().toString());
                int bowler_run = Integer.parseInt(bowler_runs.getText().toString());
                bowler_run += 4;
                bowler_runs.setText("" + bowler_run);
                mScore += 4;
                score.setText("" + mScore);
                updateOver();
                break;
            }
            case 5: {
                int mScore = Integer.parseInt(score.getText().toString());
                int bowler_run = Integer.parseInt(bowler_runs.getText().toString());
                bowler_run += 5;
                bowler_runs.setText("" + bowler_run);
                mScore += 5;
                score.setText("" + mScore);
                updateOver();
                break;
            }
            case 6: {

                int mScore = Integer.parseInt(score.getText().toString());
                int bowler_run = Integer.parseInt(bowler_runs.getText().toString());
                bowler_run += 6;
                bowler_runs.setText("" + bowler_run);
                mScore += 6;
                score.setText("" + mScore);
                updateOver();
                break;
            }
            case 7: {

                int mScore = Integer.parseInt(score.getText().toString());
                int bowler_run = Integer.parseInt(bowler_runs.getText().toString());
                bowler_run += 1;
                bowler_runs.setText("" + bowler_run);
                mScore += 1;
                score.setText("" + mScore);
                updateOver();
                break;
            }
        }

    }

    private void updateZeroScore() {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        updateOver();
    }

    private void updateOver() {
        int overbals = Integer.parseInt(over_balls.getText().toString());
        int bowler_ov = Integer.parseInt(bowler_over_balls.getText().toString());

        if (overbals == 5 && bowler_ov == 5) {
            int temp_over = Integer.parseInt(over.getText().toString());
            int temp_bowl_over = Integer.parseInt(bowler_overs.getText().toString());
            temp_bowl_over++;
            temp_over++;
            over.setText("" + temp_over);
            bowler_overs.setText("" + temp_bowl_over);
            DecimalFormat df2 = new DecimalFormat("#.##");

            bowler_over_balls.setText("" + 0);
            over_balls.setText("" + 0);
            Double movers = Double.parseDouble(over.getText().toString());
            Double mscore = Double.parseDouble(score.getText().toString());
            Toast.makeText(this, ""+mscore, Toast.LENGTH_SHORT).show();

            Double mcrr = mscore / movers;
            crr.setText("" + df2.format(mcrr));
        } else {
            over_balls.setText("" + (overbals + 1));
            bowler_over_balls.setText("" + (bowler_ov + 1));
        }
    }

    public void swapBatsman(View view) {
        swapBatsman();
    }
//    private void swapBatsMan(){
//        player_view_1.gevi
//    }

}

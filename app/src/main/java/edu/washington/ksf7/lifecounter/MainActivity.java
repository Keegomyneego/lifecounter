package edu.washington.ksf7.lifecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int INITIAL_PLAYER_HEALTH = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializePlayer(R.id.player_1_card, "Player 1");
        initializePlayer(R.id.player_2_card, "Player 2");
        initializePlayer(R.id.player_3_card, "Player 3");
        initializePlayer(R.id.player_4_card, "Player 4");
    }

    private void initializePlayer(final int playerId, String name) {
        View player = findViewById(playerId);

        ((TextView) player.findViewById(R.id.player_name)).setText(name);
        ((TextView) player.findViewById(R.id.player_health)).setText(String.valueOf(INITIAL_PLAYER_HEALTH));

        player.findViewById(R.id.minus_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlayerHealth(playerId, -1);
            }
        });

        player.findViewById(R.id.plus_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlayerHealth(playerId, +1);
            }
        });

        player.findViewById(R.id.minus_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlayerHealth(playerId, -5);
            }
        });

        player.findViewById(R.id.plus_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlayerHealth(playerId, +5);
            }
        });
    }

    private void changePlayerHealth(int playerId, int amount) {
        View player = findViewById(playerId);

        String playerName = ((TextView) player.findViewById(R.id.player_name)).getText().toString();
        TextView playerHealthView = ((TextView) player.findViewById(R.id.player_health));

        int currentHealth = Integer.valueOf(playerHealthView.getText().toString());
        int newHealth = currentHealth + amount;

        // update health
        playerHealthView.setText(String.valueOf(newHealth));

        // check lose condition
        if (newHealth <= 0) {
            ((TextView) findViewById(R.id.game_info)).setText(playerName + " LOSES!");
        }
    }

}

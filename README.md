# Blackjack Card Game

## Overview

This Java program implements a simple text-based version of the classic Blackjack card game. Players can enjoy the game by entering the names of three participants and making decisions during their turns. The game includes standard Blackjack rules, such as hitting or standing, with the goal of having a hand value closest to 21 without exceeding it.

## Features

- Three-player Blackjack game.
- User-friendly text-based interface.
- Standard Blackjack rules and win conditions.
- Option to restart the game after completion.

## How to Play

1. Run the `Blackjack` class.
2. Enter the names of the three players.
3. The game will deal cards and prompt each player to hit or stand.
4. Follow the on-screen instructions to play your turn.
5. After all players have completed their turns, the dealer's hand is revealed, and the winner is determined.

## How to Restart

- After completing a game, you will be prompted with "Do you want to play again: (y or n)."
- Type 'y' to restart the game or 'n' to end it.
- Invalid entries will prompt a re-entry request.

## Programming Techniques

This Blackjack card game utilizes various programming techniques, including:

- **Object-Oriented Programming (OOP):** The code is structured using classes (e.g., `Player`, `Deck`, `Dealer`) to encapsulate data and behaviors, promoting modularity and code organization.

- **Input Handling:** The program uses the `Scanner` class to handle user input during the game, ensuring a smooth and interactive experience.

- **Collections:** An `ArrayList` is employed to manage the collection of players, facilitating easy iteration and manipulation.

- **Control Flow:** Conditional statements and loops control the game's flow, enabling dynamic decision-making based on player input.

- **Methods:** The code is organized into methods (e.g., `initialDeal`, `play`, `endResults`) to enhance readability, maintainability, and code reusability.

- **Error Handling:** The program includes error handling to manage invalid user inputs, providing clear instructions for re-entry.

## Dependencies

- This program uses standard Java libraries.

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Created by Myles Sullivan, Sean Prevett, Thomas Michael and Ben Mallet
- Special thanks to Professor Dave Rosenberg for his guidance and permission to use his classes

Feel free to enjoy the game, and may the odds be ever in your favor!

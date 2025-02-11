import random
import matplotlib.pyplot as plt

transition_matrix_computer = {
    "Paper": {"Paper": 2 / 3, "Rock": 1 / 3, "Scissors": 0 / 3},
    "Rock": {"Paper": 0 / 3, "Rock": 2 / 3, "Scissors": 1 / 3},
    "Scissors": {"Paper": 2 / 3, "Rock": 0 / 3, "Scissors": 1 / 3}
}

counter_strategy = {"Paper": "Scissors", "Rock": "Paper", "Scissors": "Rock"}

transition_matrix_player = {
    "Paper": {"Paper": 1 / 3, "Rock": 1 / 3, "Scissors": 1 / 3},
    "Rock": {"Paper": 1 / 3, "Rock": 1 / 3, "Scissors": 1 / 3},
    "Scissors": {"Paper": 1 / 3, "Rock": 1 / 3, "Scissors": 1 / 3}
}

rules = {"Paper": "Rock", "Rock": "Scissors", "Scissors": "Paper"}

states = ["Paper", "Rock", "Scissors"]

learning_rate = 0.05


def play_game(player_move, computer_move):
    if player_move == computer_move:
        return 0
    elif rules[player_move] == computer_move:
        return 1
    else:
        return -1


def choose_move_computer(previous_move):
    probabilities = transition_matrix_computer[previous_move]
    return random.choices(list(probabilities.keys()), weights=probabilities.values())[0]


def choose_move_player_v1(computer_previous_move):
    return counter_strategy[computer_previous_move]


def choose_move_player_v2(previous_move):
    probabilities = transition_matrix_player[previous_move]
    moves = list(probabilities.keys())
    return random.choices(moves, weights=list(probabilities.values()))[0]


def update_transition_matrix_player(previous_move, current_move, result):
    if result == 1:
        for state in states:
            if state == current_move:
                transition_matrix_player[previous_move][state] += learning_rate
            else:
                transition_matrix_player[previous_move][state] -= learning_rate / 2
    elif result == -1:
        for state in states:
            if state == current_move:
                transition_matrix_player[previous_move][state] -= learning_rate
            else:
                transition_matrix_player[previous_move][state] += learning_rate / 2

    total_prob = sum(transition_matrix_player[previous_move].values())
    for state in states:
        transition_matrix_player[previous_move][state] /= total_prob


def simulate_game(version):
    cash = 0
    cash_history = [cash]

    computer_previous_move = random.choice(states)
    player_previous_move = random.choice(states)

    for i in range(10000):
        if version == 1:
            player_move = choose_move_player_v1(computer_previous_move)
        else:
            player_move = choose_move_player_v2(player_previous_move)

        computer_move = choose_move_computer(computer_previous_move)
        result = play_game(player_move, computer_move)

        cash += result
        cash_history.append(cash)

        if version == 2:
            update_transition_matrix_player(player_previous_move, player_move, result)

        computer_previous_move = computer_move
        player_previous_move = player_move
        if i % 100 == 0:
            print(transition_matrix_player)

    plt.plot(cash_history)
    plt.xlabel('Game Number')
    plt.ylabel('Cash Amount')
    plt.title(f'Cash Amount Over Time in "Rock, Paper, Scissors" (Version {version})')
    plt.show()


simulate_game(1)
simulate_game(2)

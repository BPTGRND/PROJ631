from data import Data
from user import User
from systemnode import SystemNode
from system import System

if __name__ == "__main__":
    data_list = [
        Data(0, 10),
        Data(1, 20),
        Data(2, 40),
        Data(3, 10),
        Data(4, 10),
        Data(5, 30),
        Data(6, 10),
        Data(7, 10),
        Data(8, 20)
    ]

    system_node_list = [
        SystemNode(0, 50, {1: 1, 2: 3, 3: 3, 4: 1}),
        SystemNode(1, 40, {0: 1, 2: 1, 3: 3, 4: 3}),
        SystemNode(2, 50, {0: 3, 1: 1, 3: 1, 4: 3}),
        SystemNode(3, 40, {0: 3, 1: 3, 2: 1, 4: 1}),
        SystemNode(4, 40, {0: 1, 1: 3, 2: 3, 3: 1})
    ]

    user_list = [
        User(0, [0], 0),
        User(1, [1, 2], 0),
        User(2, [3, 5], 0),
        User(3, [4], 1),
        User(4, [6], 2),
        User(5, [4, 8], 3),
        User(6, [0, 7], 3)
    ]

    system = System(data_list, system_node_list, user_list)
    system.place_data()

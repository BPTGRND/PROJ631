import heapq


class System:
    # CONSTRUCTOR
    def __init__(self, data_list, system_node_list, user_list):
        self.data_list = data_list
        self.system_node_list = system_node_list
        self.user_list = user_list

    # FUNCTION THAT RETURNS THE SHORTEST DISTANCE BETWEEN AN USER AND A NODE
    def get_distance(self, user_id, node_id):
        distances = {node.id: float('inf') for node in self.system_node_list}
        visited = set()
        for user in self.user_list:
            if user.get_id() == user_id:
                user_node_id = user.get_accessible_node_id()
                break
        else:
            return None
        distances[user_node_id] = 0
        heap = [(0, user_node_id)]
        while heap:
            current_distance, current_node_id = heapq.heappop(heap)
            if current_node_id in visited:
                continue
            if current_node_id == node_id:
                return current_distance
            visited.add(current_node_id)
            for neighbor_id, weight in self.system_node_list[current_node_id].accessible_node_ids.items():
                distance = current_distance + weight
                if distance < distances[neighbor_id]:
                    distances[neighbor_id] = distance
                    heapq.heappush(heap, (distance, neighbor_id))
        return None

    # FUNCTION THAT RETURNS THE REMAINING SIZE OF A NODE
    def get_remaining_size(self, node):
        total_size = 0
        for data_id in node.get_local_data_ids():
            for data in self.data_list:
                if data.get_id() == data_id:
                    total_size += data.get_size()
                    break
        remaining_size = node.get_memory_capacity() - total_size
        return remaining_size

    # FUNCTION THAT PLACES THE DATA ON THE SYSTEM
    def place_data(self):
        sorted_data = sorted(self.data_list, key=lambda x: x.get_id())
        for data in sorted_data:
            interested_user = None
            for user in self.user_list:
                if data.get_id() in user.get_interest_data_ids():
                    interested_user = user
                    break
            if interested_user is None:
                print(f"Aucun utilisateur intéressé par la donnée {data.get_id()}")
                continue

            node_distances = {}
            for node in self.system_node_list:
                distance = self.get_distance(interested_user.get_id(), node.get_id())
                if distance is not None:
                    node_distances[node.get_id()] = distance
            if not node_distances:
                print(f"Aucun nœud accessible à l'utilisateur {interested_user.get_id()}")
                continue

            sorted_nodes = sorted(node_distances.items(), key=lambda x: x[1])

            data_placed = False
            for node_id, _ in sorted_nodes:
                for node in self.system_node_list:
                    if node.get_id() == node_id:
                        if data.get_size() <= self.get_remaining_size(node):
                            print(f"Capacité du noeud {node.get_id()} avant l'ajout de la donnée : {self.get_remaining_size(node)}")
                            node.add_local_data(data.get_id())
                            print(f"Donnée {data.get_id()} ({data.get_size()}) placée avec succès sur le nœud {node.get_id()}")
                            print(f"Capacité du noeud {node.get_id()} après l'ajout de la donnée : {self.get_remaining_size(node)}")
                            print("\n")
                            data_placed = True
                            break
                if data_placed:
                    break
            if not data_placed:
                print(f"Aucun nœud n'a suffisamment de mémoire disponible pour placer la donnée {data.get_id()}")

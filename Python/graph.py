class Node:
    def __init__(self, pos):
        self.pos = pos
        self.next = []

# Initialize the graph start node
Start = None

# To add the start node
def AddStartPoint(c):
    global Start
    Start = Node(c)

# Search for a node with given value using BFS
def SearchNode(v):
    if Start is None:
        return False
    nodelist = [Start]
    while nodelist:
        if nodelist[0].pos == v:
            return True
        b = nodelist.pop(0)
        nodelist.extend(b.next)
    return False

# Return the node object with given value
def ReturnNode(c):
    if Start is None:
        return None
    nodelist = [Start]
    while nodelist:
        if nodelist[0].pos == c:
            return nodelist[0]
        b = nodelist.pop(0)
        nodelist.extend(b.next)
    return None

# Add edge from c1 to c2
def AddEdge(c1, c2):
    if SearchNode(c1):
        if SearchNode(c2):
            v1 = ReturnNode(c1)
            v2 = ReturnNode(c2)
            for m in v1.next:
                if m.pos == v2.pos:
                    print(f"{v2.pos} is already connected to {v1.pos}!")
                    return
            v1.next.append(v2)
            print(f"{v2.pos} is successfully added to {v1.pos}")
        else:
            v3 = Node(c2)
            v4 = ReturnNode(c1)
            v4.next.append(v3)
            print(f"{c2} is successfully created and added to {c1}")
    else:
        print(f"{c1} not found!")

# Display the graph using BFS
def Display():
    if Start is None:
        print("Found empty graph!")
    else:
        hj = [Start]
        while hj:
            j = hj.pop(0)
            print(f"Scanning position: {j.pos}")
            for b in j.next:
                print(f"{j.pos} -> {b.pos}")
                hj.append(b)

# Main testing
if __name__ == "__main__":
    AddStartPoint("Mumbai")
    AddEdge("Mumbai", "Pune")
    AddEdge("Pune", "Nashik")
    AddEdge("Mumbai", "Nashik")
    AddEdge("Nashik", "Nagpur")
    Display()
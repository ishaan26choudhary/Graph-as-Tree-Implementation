package main

import "fmt"

// Both search and display functions will use BFS algorithm

// Define the structure of the graph node
type Node struct {
	pos string
	next []*Node
}

// Initialize the graph 
var Start *Node=nil

// To add the start node
func AddStartPoint(c string){
	node := &Node{
		pos: c,
		next: []*Node{},
	}
	Start=node
}

// This function will search for the given node and returns true if it is found, else it returns false
func SearchNode(v string) bool {
	if Start == nil {
		return false
	}
	var nodelist []*Node
	nodelist = append(nodelist, Start)
	for len(nodelist) != 0 {
		if nodelist[0].pos == v {
			return true
		}
		b := nodelist[0]
		for _, nextNode := range b.next {
			nodelist = append(nodelist, nextNode)
		}
		nodelist = nodelist[1:]
	}
	return false
}

// It searches for the given node and returns it if it is found, else it returns nil
func ReturnNode(c string) *Node {
	if Start == nil {
		return nil
	}
	var nodelist []*Node
	nodelist = append(nodelist, Start)
	for len(nodelist) != 0 {
		if nodelist[0].pos == c {
			return nodelist[0]
		}
		b := nodelist[0]
		for _, nextNode := range b.next {
			nodelist = append(nodelist, nextNode)
		}
		nodelist = nodelist[1:]
	}
	return nil
}

// This function adds the given node c1 to node c2
func AddEdge(c1,c2 string){
	if SearchNode(c1){
		if SearchNode(c2){
			v1 := ReturnNode(c1)
			v2 := ReturnNode(c2)
			k := 0
			for _,m := range v1.next{
				if m.pos==v2.pos{
					fmt.Println(v2.pos," is already connected to ",v1.pos," !")
					k=1
				}
			}
			if k==0{
				v1.next=append(v1.next,v2)
				fmt.Println(v2.pos,"is successfully added to ",v1.pos)
			}
		}else{
			v3:=&Node{
				pos: c2,
		        next: []*Node{},
			}
			v4 := ReturnNode(c1)
		    v4.next=append(v4.next,v3)
			fmt.Println(v4.pos," is successfully created and Added to ",v3.pos)
		}	
	}else{
		fmt.Println(c1," not found !")
	}
}

// This function will display the graph
func Display(){
	hj := []*Node{}
	if Start==nil{
		fmt.Println("Found empty graph !")
	}else{
		hj=append(hj,Start)
		for len(hj)!=0{
			j := hj[0]
			fmt.Println("Scanning position: ",j.pos)
			for _,b := range j.next{
				fmt.Println(j.pos,"->",b.pos)
				hj=append(hj,b)
			}
			hj=hj[1:]
		}
	}
}

// Tested in the main function
func main(){
	AddStartPoint("Mumbai")
	AddEdge("Mumbai","Pune")
	AddEdge("Pune","Nashik")
	AddEdge("Mumbai","Nashik")
	AddEdge("Nashik","Nagpur")
	Display()
}


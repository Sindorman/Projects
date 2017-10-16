int simpleEx(int x, int y);
int main(){
	int x = 12;
	int y = simpleEx(x, x-5);
	y = y + simpleEx(14, x);
	return 0;
}
int simpleEx(int x, int y){
	int z = 7;
	return x + 2*y - z;
}

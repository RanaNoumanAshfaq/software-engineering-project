#include <iostream>
#include <windows.h>
#include <limits>
#include <algorithm>

using namespace std;

const int MAX_CARS = 10;
const int MAX_STAFF = 10;

class ShowRoom {
private:
    struct Car {
        int id;
        string name;
        string color;
        int model;
        int price;
    };
    Car cars[MAX_CARS];
    int carCount;

public:
    ShowRoom() {
        carCount = 0;
    }

    void insertCar(int id, string name, string color, int model, int price) {
        if (carCount < MAX_CARS) {
            cars[carCount].id = id;
            cars[carCount].name = name;
            cars[carCount].color = color;
            cars[carCount].model = model;
            cars[carCount].price = price;
            carCount++;
            cout << "\nCar Added Successfully\n";
        } else {
            cout << "\nCar Storage Full\n";
        }
    }

    void deleteCar(int id) {
        for (int i = 0; i < carCount; ++i) {
            if (cars[i].id == id) {
                for (int j = i; j < carCount - 1; ++j) {
                    cars[j] = cars[j + 1];
                }
                --carCount;
                cout << "\nCar Deleted Successfully\n";
                return;
            }
        }
        cout << "\nCar not found\n";
    }

    void updateCar(int id, string name, string color, int model, int price) {
        for (int i = 0; i < carCount; ++i) {
            if (cars[i].id == id) {
                cars[i].name = name;
                cars[i].color = color;
                cars[i].model = model;
                cars[i].price = price;
                cout << "\nCar Updated Successfully\n";
                return;
            }
        }
        cout << "\nCar not found\n";
    }

    void searchCar(int id) {
        for (int i = 0; i < carCount; ++i) {
            if (cars[i].id == id) {
                cout << "\n*Founded*\n";
                return;
            }
        }
        cout << "\n*Not Found*\n";
    }

    void viewCars() {
        for (int i = 0; i < carCount; ++i) {
            cout << "Car ID: " << cars[i].id << " -> ";
            cout << "Car Name: " << cars[i].name << " -> ";
            cout << "Car Price: " << cars[i].price << " -> ";
 
            cout << "Car Model: " << cars[i].model << "\n";
        }
        cout << "" << endl;
    }
};

class Admin {
private:
    struct Staff {
        int id;
        string name;
        int age;
        string gender;
        int salary;
    };
    Staff staffMembers[MAX_STAFF];
    int staffCount;

public:

    Admin() {
        staffCount = 0;
    }

    void addStaff(int id, string name, int age, string gender, int salary) {
        if (staffCount < MAX_STAFF) {
            staffMembers[staffCount].id = id;
            staffMembers[staffCount].name = name;
            staffMembers[staffCount].age = age;
            staffMembers[staffCount].gender = gender;
            staffMembers[staffCount].salary = salary;
            staffCount++;
            cout << "\nStaff Member Added Successfully\n";
        } else {
            cout << "\nStaff Storage Full\n";
        }
    }

    void deleteStaff(int id) {
        for (int i = 0; i < staffCount; ++i) {
            if (staffMembers[i].id == id) {
                for (int j = i; j < staffCount - 1; ++j) {
                    staffMembers[j] = staffMembers[j + 1];
                }
                --staffCount;
                cout << "\nStaff Member Deleted Successfully\n";
                return;
            }
        }
        cout << "\nStaff Member not found\n";
    }

    void updateStaff(int id, string name, int age, string gender, int salary) {
        for (int i = 0; i < staffCount; ++i) {
            if (staffMembers[i].id == id) {
                staffMembers[i].name = name;
                staffMembers[i].age = age;
                staffMembers[i].gender = gender;
                staffMembers[i].salary = salary;
                cout << "\nStaff Member Updated Successfully\n";
                return;
            }
        }
        cout << "\nStaff Member not found\n";
    }

    void searchStaff(int id) {
        for (int i = 0; i < staffCount; ++i) {
            if (staffMembers[i].id == id) {
                cout << "\n^^^Founded^^^\n";
                return;
            }
        }
        cout << "\n^^^Not Found^^^\n";
    }

    void viewStaff() {
        for (int i = 0; i < staffCount; ++i) {
            cout << "Staff ID: " << staffMembers[i].id << " -> ";
            cout << "Name: " << staffMembers[i].name << " -> ";
            cout << "Age: " << staffMembers[i].age << " -> ";
            cout << "Gender: " << staffMembers[i].gender << " -> ";
            cout << "Salary: " << staffMembers[i].salary << "\n";
        }
        cout << "" << endl;
    }
};

class Buyer {
private:
    struct BuyerInfo {
        int id;
        string name;
        int days;
    };
    BuyerInfo buyers[MAX_CARS];
    int buyerCount;

public:
    Buyer() {
        buyerCount = 0;
    }

    void rentCar(int id, string name, int days) {
        if (buyerCount < MAX_CARS) {
            buyers[buyerCount].id = id;
            buyers[buyerCount].name = name;
            buyers[buyerCount].days = days;
            buyerCount++;
            cout << "\nCar Rented Successfully\n";
        } else {
            cout << "\nMaximum Cars Rented\n";
        }
    }

    void displayRentedCars() {
        for (int i = 0; i < buyerCount; ++i) {
            cout << "ID: " << buyers[i].id << " -> ";
            cout << "Car Name: " << buyers[i].name << " -> ";
            cout << "Days: " << buyers[i].days << "\n";
        }
        cout << "NULL" << endl;
    }
};

int strt() {
    Sleep(200);
    cout << "\t\t\t\t                 ______________              " << endl;
    Sleep(200);
    cout << "\t\t\t\t                 |             |             " << endl;
    Sleep(200);
    cout << "\t\t\t\t                 |             |             " << endl;
    Sleep(200);
    cout << "\t\t\t\t                 |             |             " << endl;
    Sleep(200);
    cout << "\t\t\t\t_________________|             |___________________" << endl;
    Sleep(200);
    cout << "\t\t\t\t|                                                  |" << endl;
    Sleep(200);
    cout << "\t\t\t\t|                                                  |" << endl;
    Sleep(200);
    cout << "\t\t\t\t|                                                  |" << endl;
    Sleep(200);
    cout << "\t\t\t\t|              Welcome to car Rental               |" << endl;
    Sleep(200);
    cout << "\t\t\t\t|                Management System                 |" << endl;
    Sleep(200);
    cout << "\t\t\t\t|                                                  |" << endl;
    Sleep(200);
    cout << "\t\t\t\t|                                                  |" << endl;
    Sleep(200);
    cout << "\t\t\t\t|       ________             ________              |" << endl;
    Sleep(200);
    cout << "\t\t\t\t|_______|       |____________|       |_____________|" << endl;
    Sleep(200);
    cout << "\t\t\t\t        |       |            |       |       " << endl;
    Sleep(200);
    cout << "\t\t\t\t        |       |            |       |       " << endl;
    Sleep(200);
    cout << "\t\t\t\t        |_______|            |_______|       " << endl;
    Sleep(200);

    cout << "\n\n\t\t\t\t\t%%%%CAR MANAGEMENT SYSTEM%%%%" << endl;
    Sleep(800);
    return 0;
}

int main() {
	strt();
    ShowRoom carShowRoom;
    Admin admin;
    Buyer buyer;

    int choice;
    int carId, staffId, buyerId,model;
    string name, color, gender;
    int age, salary, price, days;
    bool exitProgram = false;

    while (!exitProgram) {
        system("color 70");

        cout << "\n\nEnter any number as:\n1 - Car ShowRoom\n2 - Admin\n3 - Rent a Car\n4 - Exit\n\n";
        while (!(cin >> choice) || cin.peek() != '\n' || choice < 1 || choice > 4) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input. Please enter a valid number : ";
        }

        switch (choice) {
            case 1: {
                int carChoice;
                cout << "\n****Car ShowRoom******\n";

                cout << "Enter choice\n1 - Add Car\n2 - Delete Car\n3 - Update Car\n4 - Search Car\n5 - View Car\n6 - Back\n";
                while (!(cin >> carChoice) || cin.peek() != '\n' || carChoice < 1 || carChoice > 6) {
                    cin.clear();
                    cin.ignore(numeric_limits<streamsize>::max(), '\n');
                    cout << "Invalid input. Please enter a valid number : ";
                }

                switch (carChoice) {
                    case 1: {
                        cout << "Enter Car details:\n";
                        cout << "ID: ";
                        while (!(cin >> carId) || cin.peek() != '\n' || carId < 1) {
                            cin.clear();
                            cin.ignore(numeric_limits<streamsize>::max(), '\n');
                            cout << "Invalid input. Please enter a valid car ID : ";
                        }

						cout << "Name: ";
						cin.ignore();
						getline(cin,name);

                        cout << "Color: ";
                        cin >> color;

                        cout << "Model: ";
        
                        while (!(cin >> model) || cin.peek() != '\n' || model <1950 || model >2023) {
                        	
			            cin.clear();
			            cin.ignore(numeric_limits<streamsize>::max(), '\n');
			            cout << "Invalid input. Please enter a valid model(1950 - 2023) : ";
				        }

                        cout << "Price: ";
                        while (!(cin >> price) || cin.peek() != '\n' || price < 1) {
                            cin.clear();
                            cin.ignore(numeric_limits<streamsize>::max(), '\n');
                            cout << "Invalid input. Please enter a valid price : ";
                        }

                        carShowRoom.insertCar(carId, name, color, model, price);
                        break;
                    }
                     case 2:
                            {
                                cout << "Enter Car ID to delete: ";
                                while (!(cin >> carId) || cin.peek() != '\n' || carId< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid car ID : ";
								}
                                carShowRoom.deleteCar(carId);
                                break;
                            }
                        case 3:
                            {
                                cout << "Enter Car ID to update: ";
                                while (!(cin >> carId) || cin.peek() != '\n' || carId< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid car ID : ";
								}
                                cout << "Enter updated details:\n";
                                cout << "Name: ";
                                cin.ignore();
                                getline(cin,name);
                                cout << "Color: ";
                                cin >> color;
                                cout << "Model: ";
                                while (!(cin >> model) || cin.peek() != '\n' || model <1950 || model >2023) {
					            cin.clear();
					            cin.ignore(numeric_limits<streamsize>::max(), '\n');
					            cout << "Invalid input. Please enter a valid model(1950 - 2023) : ";
						        }
                                cout << "Price: ";
                                while (!(cin >> price) || cin.peek() != '\n' || price< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid price : ";
								}
                                carShowRoom.updateCar(carId, name, color, model, price);
                                break;
                            }
                        case 4:
                            {
                                cout << "Enter Car ID to search: ";
                                while (!(cin >> carId) || cin.peek() != '\n' || carId< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid number : ";
								}
                                carShowRoom.searchCar(carId);
                                break;
                            }
                        case 5:
                            {
                                cout << "\n*View Cars*\n";
                                carShowRoom.viewCars();
                                break;
                            }
                        case 6:
                            {
                                break;
                            }
                        default:
                            {
                                cout << "Invalid choice for Car ShowRoom\n";
                                
                                break;
                            }
                    }
                    break;
                }
                p:
            case 2:
                {int id;
                string password;
                
                    int adminChoice;
                    cout<<"enter id";
                    cin>>id;
                    cout<<"enter password";
                    cin.ignore();
                getline(cin,password);
                    
                    if(id==46488&&password=="rana@123"){
                    cout << "\n****Admin******\n";
                    cout << "Enter choice\n1 - Add Staff\n2 - Delete Staff\n3 - Update Staff\n4 - Search Staff\n5 - View Staff\n6 - Back\n";
					while (!(cin >> adminChoice) || cin.peek() != '\n' || adminChoice< 1 || adminChoice> 6) {
						cin.clear();
                        cin.ignore(numeric_limits<streamsize>::max(), '\n');
                        cout << "Invalid input. Please enter a valid number : ";
				   
					}
				
                    switch (adminChoice) {
                        case 1:
                            {
                                cout << "Enter Staff details:\n";
                                cout << "ID: ";
                                while (!(cin >> staffId) || cin.peek() != '\n' || staffId< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid number : ";
								}
	
								cout << "Name: ";
								cin.ignore();
								getline(cin,name);
                                
                                cout << "Age: ";
                                while (!(cin >> age) || cin.peek() != '\n' || age< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid number : ";
								}
                                cout << "Gender :  ";
                                cin >> gender;
                                while(gender!="male" && gender!="Male" && gender!="female" && gender!="Female") {
							    cout << "Please enter valid input male or female : ";
							    cin >> gender;
								}

                                cout << "Salary: ";
                                while (!(cin >> salary) || cin.peek() != '\n' || salary< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid number : ";
								}
                                admin.addStaff(staffId, name, age, gender, salary);
                                break;
                            }
                        case 2:
                            {
                                cout << "Enter Staff ID to delete: ";
                                cin >> staffId;
                                admin.deleteStaff(staffId);
                                break;
                            }
                        case 3:
                            {
                                cout << "Enter Staff ID to update: ";
                                while (!(cin >> staffId) || cin.peek() != '\n' || staffId< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid number : ";
								}
                                cout << "Enter updated details:\n";
                                
                                cout << "Name: ";
								cin.ignore();
								getline(cin,name);
                                
                                cout << "Age: ";
                                while (!(cin >> age) || cin.peek() != '\n' || age< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid number : ";
								}
                                cout << "Gender: ";
                                cin >> gender;
                                while(gender!="male" && gender!="Male" && gender!="female" && gender!="Female") {
							    cout << "Please enter valid input male or female : ";
							    cin >> gender;
								}
                                cout << "Salary: ";
                                while (!(cin >> salary) || cin.peek() != '\n' || salary< 1 ) {
							    cin.clear();
                                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                               cout << "Invalid input. Please enter a valid number : ";
								}
                                admin.updateStaff(staffId, name, age, gender, salary);
                                break;
                            }
                        case 4:
                            {
                                cout << "Enter Staff ID to search: ";
                                while (!(cin >> staffId) || cin.peek() != '\n' || staffId< 1 ) {
							   cin.clear();
                               cin.ignore(numeric_limits<streamsize>::max(), '\n');
                               cout << "Invalid input. Please enter a valid number : ";
								}
                                admin.searchStaff(staffId);
                                break;
                            }
                        case 5:
                            {
                                cout << "\n^^All Staffs^^\n";
                                admin.viewStaff();
                                break;
                            }
                        case 6:
                            {
                                break;
                            }
                        default:
                            {
                                cout << "Invalid choice for Admin\n";
                                break;
                            }
                    }
                    break;
                }
                
            
            else{
			cout<<"invalid output"<<endl;
			cout<<" ENTER AGAIN";
			goto p;
			}
		}
            case 3:
                {
                    int buyerChoice;
                    cout << "\n****Buyer******\n";
                    cout << "Enter choice\n1 - View Cars\n2 - Rent a Car\n3 - View Rented Cars\n4 - Back\n";
                    while (!(cin >> buyerChoice) || cin.peek() != '\n' || buyerChoice< 1 || buyerChoice> 4) {
				    cin.clear();
				    cin.ignore(numeric_limits<streamsize>::max(), '\n');
				    cout << "Invalid input. Please enter a valid number : ";
					}
                    switch (buyerChoice) {
                        case 1:
                            {
                                cout << "\n*View Cars*\n";
                                carShowRoom.viewCars();
                                break;
                            }
                        case 2:
                            {
                                int rentedCarId;
                                cout << "Enter Car ID to rent: ";
                                while (!(cin >> rentedCarId) || cin.peek() != '\n' || rentedCarId < 1) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid  number : ";
							}
							
								cout << "Name: ";
								cin.ignore();
								getline(cin,name);
								
                                cout << "Enter rental days: ";
                                while (!(cin >> days) || cin.peek() != '\n' || days< 1 ) {
							    cin.clear();
							    cin.ignore(numeric_limits<streamsize>::max(), '\n');
							    cout << "Invalid input. Please enter a valid number : ";
								}
                                buyer.rentCar(rentedCarId, name, days);
                                break;
                            }
                        case 3:
                            {
                                cout << "\n*Rented Cars*\n";
                                buyer.displayRentedCars();
                                break;
                            }
                        case 4:
                            {
                                break;
                            }
                        default:
                            {
                                cout << "Invalid choice for Buyer\n";
                                break;
                            }
                    }
                    break;
                }
            case 4:
                {
                    exitProgram = true;
                    break;
                }
            default:
                {
                    cout << "Invalid choice\n";
                    break;
                }
        }

        
    }

    return 0;
}




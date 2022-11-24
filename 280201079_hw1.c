#include <stdio.h>
#include <stdlib.h>

//Elif Özyürek 280201079

typedef struct dynamic_array {
    int capacity;
    int size;
    void** elements;
} dynamic_array;


void init_array(dynamic_array* array) {
    array->elements = malloc(2*sizeof(void*));
    array->capacity = 2;
    array->size = 0;

    array->elements[0] = NULL;
    array->elements[1] = NULL;
}



void put_element(dynamic_array* array, void* element) {

    if (array->size == array->capacity){
        int temp_capacity = array->capacity * 2;
        void** temp_elements;
        temp_elements = (void**) malloc(temp_capacity * sizeof(void*));      
        for (int i=0; i < array->capacity; i++){
            if (array->elements[i] != NULL){
                temp_elements[i] = array->elements[i];
            }
            else{  
                temp_elements[i] = NULL;
            }
        }
        array->capacity = temp_capacity;
        array->elements = temp_elements;
    }
   
    for (int i=0; i < array->capacity; i++){
        if (array->elements[i] != NULL){
            continue;
        }
        else{  
            array->elements[i] = element;
            array->size++;
            break;
        }
    }
    
}


void remove_element(dynamic_array* array, int position) {
    if (array->size == array->capacity/2){
        int temp_capacity = array->capacity / 2;
        void** temp_elements;
        temp_elements = (void**) malloc(temp_capacity * sizeof(void*));
        for (int i=0; i < array->capacity; i++){
            if (array->elements[i] != NULL){
                temp_elements[i] = array->elements[i];
            }
            else{  
                temp_elements[i] = NULL;
            }
        }
        array->capacity = temp_capacity;
        array->elements = temp_elements;
    }

    for (int i=0; i < array->capacity; i++){
        if (array->elements[i] != NULL && i == position){
            array->elements[i] = NULL;
            free(array->elements[i]);
        }
    }
    array->size--;

}


void* get_element(dynamic_array* array, int position) {
    for (int i=0; i < array->capacity; i++){
        if (array->elements[i] != NULL && i == position){
            return array->elements[i];
        }
    }
}


typedef struct song {
    char* name;
    float duration;
} song;


int main() {

    dynamic_array* arr_ptr;
    dynamic_array arr;
    arr_ptr = &arr;

    init_array(arr_ptr);
    
    int check = 1;

    while (check){
        int option;
        printf("\nSelect an Option:\n1-Add Song\n2-Remove Song\n3-List Songs\n4-Exit\n");
        scanf("%d", &option);

        if (option == 1){     
            char* song_name = malloc(64*sizeof(char));
            float song_duration;

            printf("Enter song name:\n");
            scanf("%s", song_name);
            printf("Enter song duration:\n");
            scanf("%f", &song_duration);
            
            song new_song = {song_name, song_duration};
            song* song_ptr = (song*) malloc(sizeof(song));
            song_ptr->duration = song_duration;
            song_ptr->name = song_name;

            put_element(arr_ptr, song_ptr);
        }
        else if (option == 2){
            printf("Could not figure out, please check the code\n");
        }
        else if (option == 3){
            for (int i=0; i < arr.capacity; i++){
                if (arr.elements[i] != NULL){
                    song* new_song = get_element(arr_ptr, i);
                    printf("Song Name: %s Song Duration: %f\n", new_song->name, new_song->duration);
                }
            }
        }
        else if (option == 4){
            printf("Exiting Program...\n");
            break;
        } 

    }

    return 0;
}
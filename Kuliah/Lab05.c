 /* (c) 2005-2011 Rahmat M. Samik-Ibrahim, This is Free Software *
 * $Revision: 135 $
 * $Date*
 * svn propset svn:keywords "Date Revision HeadURL Id Author"
 * JANGAN MENGHAPUS/MENGGANTI NOTA DI ATAS INI                  *
 * HARAP MENGGANTI/SESUAIKAN YANG BERIKUT INI!                  *
 ZCZC [A121] [1006685891]                                             *
 * ************************************************************ */
#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
#include<sys/wait.h>
#include<stdlib.h>

main(void) {
   /* Silakan Coba-Coba Fork!
      Jangan Lupa "commit" setiap mencoba yang lain
    */
    int id = (int) getpid(), x = 0, count = 1;
    int temp = id;
    printf("PID P1 (Induk Proses) = %d\n", id);
    fflush(stdout);
    if(fork() > 0) {
        sleep(1);
        id++; count++;
        if(fork() == 0) {
             sleep(1);
             id++; count++;
             if(fork() > 0) {
                sleep(1);
                id++; count++;
                if(fork() == 0) {
                   sleep(1);
                   id++; count++;
                }
            }
        }
    }
    int c = id;
    if(c+count == id+1 || c+count == id+2){
       if(c+count == id+1) x = temp;
       if(c+count == id+2) x = temp;
    } else if(c+count == id+3 || c+count == id+4) {
       if(c+count == id+3) x = temp+2;
       if(c+count == id+4) x = temp+2;
    } else {
       x = temp+3;
    }
    printf("PID P%d = %d Lahir - PID Induk = %d\n", count+1 , (int) (id+1), x);
    waitpid(-1, NULL, 0);
}

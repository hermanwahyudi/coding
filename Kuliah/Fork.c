/* (c) 2005-2011 Rahmat M. Samik-Ibrahim, This is Free Software *
 * $Revision: 135 $
 * $Date*
 * svn propset svn:keywords "Date Revision HeadURL Id Author"
 * JANGAN MENGHAPUS/MENGGANTI NOTA DI ATAS INI                  *
 * HARAP MENGGANTI/SESUAIKAN YANG BERIKUT INI!                  *
 ZCZC [A121] [1006685891]                                             *
 * ************************************************************ */


#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>

int main() {
     /* Silakan Coba-Coba Fork!
        Jangan Lupa "commit" setiap mencoba yang lain
     */

     int i = 1;
     printf("PID P%d (Proses Induk) = %d\n", i, (int)  getpid());
     fflush(stdout);
     if(fork() > 0) {
         sleep(1);
         if(fork() == 0) {
            i+=2; sleep(1);
            if(fork() > 0) {
                 sleep(1);
                 if(fork() == 0) i += 2;
            } else {
                i++; sleep(1);
                if(fork() == 0) i += 2;
            }
         }
     } else i++;
     if(i != 1)  printf("PID P%d = %d Lahir - Induk = %d\n", i, getpid(), getppid());
     fflush(stdout);
     waitpid(-1, NULL, 0);
     waitpid(-1, NULL, 0);
}

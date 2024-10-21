#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid;
    
    // Create a new process using the POSIX fork() system call
    pid = fork();
    
    if (pid < 0) {
        // Fork failed
        perror("Fork failed");
        exit(EXIT_FAILURE);
    } else if (pid == 0) {
        // Child process: Use exec() to run a new program (e.g., /bin/ls)
        printf("Child process: Executing /bin/ls\n");
        execl("/bin/ls", "ls", NULL);  // POSIX-compliant exec function
        perror("exec failed");  // If exec() fails
        exit(EXIT_FAILURE);
    } else {
        // Parent process: Wait for child process to complete
        wait(NULL);  // POSIX-compliant wait function
        printf("Parent process: Child process completed\n");
    }
    
    return 0;
}

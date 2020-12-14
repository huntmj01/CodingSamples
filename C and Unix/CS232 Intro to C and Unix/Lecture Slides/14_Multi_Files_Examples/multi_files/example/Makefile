CC = gcc
CFLAGS = -g
OBJS = add_sub.o mul_div.o

all: simple_cal_rev

simple_cal_rev: simple_cal_rev.c $(OBJS)
	$(CC) $(CFLAGS) $(OBJS) $< -o $@ -lm

%.o : %.c %.h
	$(CC) $(CFLAGS) -c $< -o $@

clean: 
	rm *.o simple_cal_rev

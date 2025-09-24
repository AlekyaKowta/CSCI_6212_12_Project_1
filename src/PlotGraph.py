import matplotlib.pyplot as plt
import numpy as np

# Define the input sizes (n) used for the timing tests
n = np.array([2, 10, 50, 75, 100, 200, 225, 400, 450, 500, 600, 750, 800, 1200, 1600, 1800, 2200, 2400, 4000, 6000])
# Experimental times measured (in nanoseconds) for each input size
experimental_time = np.array([170625, 27292, 141709, 397292, 740125, 1298625, 453209, 7835334, 2262125, 4080625, 6771292, 12854459, 16076541, 53021167, 123669125, 169302750, 304872625, 396345834, 1816631459, 6142635000])
# Adjusted theoretical times for each input size
# These are theoretical n^3 values scaled by a constant to match experimental scale
adjusted_theoretical_time = np.array([0.2309027778, 28.8628472222, 3607.8559028, 12176.5136719, 28862.8472222, 230902.7777778, 328765.8691406, 1847222.222222, 2630126.953125, 3607855.902778, 6234375.0, 12176513.671875, 14777777.777778, 49875000.0, 118222222.222222, 168328125.0, 307331597.222222, 399000000.0, 1847222222.222222, 6234375000.0])

# Plot raw data
# Create the plot with figure size set
plt.figure(figsize=(12, 6))
# Plot the experimental times with circle markers
plt.plot(n, experimental_time, marker='o', label='Experimental Time')
# Plot the adjusted theoretical times with square markers
plt.plot(n, adjusted_theoretical_time, marker='s', label='Adjusted Theoretical Time')
# Label the x-axis as input size n
plt.xlabel('n')
# Label the y-axis as time in nanoseconds
plt.ylabel('Time (ns)')
# Set the title of the plot
plt.title('Experimental vs Adjusted Theoretical Time')
# Show the legend to distinguish the plotted lines
plt.legend()
# Enable grid for easier reading of the plot
plt.grid(True)
plt.show()

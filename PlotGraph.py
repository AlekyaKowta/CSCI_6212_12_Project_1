import matplotlib.pyplot as plt
import numpy as np

# Create the x and y lines
n = np.array([2, 10, 50, 75, 100, 200, 225, 400, 450, 500, 600, 750, 800, 1200, 1600, 1800, 2200, 2400, 4000, 6000])
experimental_time = np.array([170625, 27292, 141709, 397292, 740125, 1298625, 453209, 7835334, 2262125, 4080625, 6771292, 12854459, 16076541, 53021167, 123669125, 169302750, 304872625, 396345834, 1816631459, 6142635000])
adjusted_theoretical_time = np.array([0.2309027778, 28.8628472222, 3607.8559028, 12176.5136719, 28862.8472222, 230902.7777778, 328765.8691406, 1847222.222222, 2630126.953125, 3607855.902778, 6234375.0, 12176513.671875, 14777777.777778, 49875000.0, 118222222.222222, 168328125.0, 307331597.222222, 399000000.0, 1847222222.222222, 6234375000.0])

# Plot raw data
plt.figure(figsize=(12, 6))
plt.plot(n, experimental_time, marker='o', label='Experimental Time')
plt.plot(n, adjusted_theoretical_time, marker='s', label='Adjusted Theoretical Time')
plt.xlabel('n')
plt.ylabel('Time (ns)')
plt.title('Experimental vs Adjusted Theoretical Time')
plt.legend()
plt.grid(True)
plt.show()

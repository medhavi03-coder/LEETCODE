import java.util.Stack;
import java.util.Arrays; // Used for splitting the string

class Solution {
    /**
     * Transforms an absolute Unix-style file path into its simplified canonical path.
     *
     * Rules followed:
     * - A single period '.' represents the current directory (ignored).
     * - A double period '..' represents the previous/parent directory (pops from stack).
     * - Multiple consecutive slashes are treated as a single slash.
     * - Any sequence of periods not matching '.' or '..' is a valid name.
     * - The path must start with a single slash '/'.
     * - Directories must be separated by exactly one slash.
     * - The path must not end with a slash, unless it's the root directory.
     * - The path must not have any single or double periods used for navigation.
     *
     * @param path The absolute Unix-style file path.
     * @return The simplified canonical path.
     */
    public String simplifyPath(String path) {
        // Use a Stack to manage directory levels.
        // When we go into a directory, we push its name onto the stack.
        // When we go up a directory ('..'), we pop from the stack.
        Stack<String> stack = new Stack<>();

        // Split the path by the '/' delimiter.
        // The split method handles multiple consecutive slashes by producing empty strings.
        // For example, "/home//foo/" splits into ["", "home", "", "foo", ""].
        String[] components = path.split("/");

        // Iterate through each component obtained from splitting the path.
        for (String component : components) {
            // Case 1: If the component is ".." (parent directory)
            if (component.equals("..")) {
                // If the stack is not empty, it means we can go up one level.
                // So, pop the current directory from the stack.
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // Case 2: If the component is "." (current directory) or an empty string (due to "//")
            // These components should be ignored as per the rules.
            else if (component.equals(".") || component.isEmpty()) {
                // Do nothing, simply ignore these components.
                continue;
            }
            // Case 3: If the component is a valid directory or file name
            // This includes names like "home", "foo", "...", "a", "b", "d".
            else {
                // Push the valid directory/file name onto the stack.
                stack.push(component);
            }
        }

        // After processing all components, reconstruct the simplified path from the stack.

        // If the stack is empty, it means the path simplifies to the root directory "/".
        if (stack.isEmpty()) {
            return "/";
        }

        // Build the canonical path by joining the elements in the stack with a single slash.
        // The path must start with a single slash '/'.
        // String.join automatically handles not ending with a slash unless it's the root.
        StringBuilder simplifiedPath = new StringBuilder();
        simplifiedPath.append("/"); // Start with the root slash

        // Iterate through the stack elements and append them, separated by slashes.
        // We can convert the stack to an array or iterate directly.
        // Using String.join is cleaner if we convert stack to a list/array.
        // Or, manually append for full control.
        
        // Convert stack to an array of strings to use String.join
        // This preserves the order (bottom of stack is first element).
        String[] finalComponents = stack.toArray(new String[0]);
        simplifiedPath.append(String.join("/", finalComponents));

        return simplifiedPath.toString();
    }
}

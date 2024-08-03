```mermaid
graph TD
    A[Start] --> B{l == r?}
    B -- Yes --> C[Create new ArrayList]
    C --> D[Add elements of nums to ArrayList]
    D --> E[Add ArrayList to list]
    E --> F[Return]
    B -- No --> G[For i from l to r]
    G --> H[Swap nums[l] and nums[i]]
    H --> I[Call permutation(nums, l+1, r, list)]
    I --> J[Swap nums[l] and nums[i] back]
    J --> G
```
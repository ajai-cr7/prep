- Checked Exceptions
- Unchecked Exceptions
- HOw it works with overridden methods of checked and unchecked exceptions.

| Superclass method throws | Subclass method can throw                                    |
| ------------------------ | ------------------------------------------------------------ |
| `IOException`            | `IOException` or subclass (e.g. `FileNotFoundException`)     |
| `IOException`            | No checked exceptions                                        |
| `IOException`            | **Cannot throw broader checked exceptions like `Exception`** |
